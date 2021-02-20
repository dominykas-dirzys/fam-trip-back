package lt.sdacademy.famtrip.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lt.sdacademy.famtrip.models.dto.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JwtAuthFilter extends BasicAuthenticationFilter {

    public static final String SECRET = "f0-fU)Ire(rJ#a34_rJP-O67es";
    public static final int VALIDITY = 60 * 60 * 1000;
    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    public JwtAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String requestTokenHeader = request.getHeader(HEADER);

        if (requestTokenHeader != null && requestTokenHeader.startsWith(PREFIX)) {
            String jwtToken = requestTokenHeader.substring(PREFIX.length());
            try {
                Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken).getBody();
                String id = claims.getId();
                String email = claims.getSubject();
                Date tokenExpirationDate = claims.getExpiration();

                if (tokenExpirationDate.after(new Date())) {
                    Authentication authentication = new UsernamePasswordAuthenticationToken(new User(Long.parseLong(id), email), null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        chain.doFilter(request, response);
    }
}
