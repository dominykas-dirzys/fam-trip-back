//package lt.sdacademy.famtrip.controllers;
//
//import lt.sdacademy.famtrip.models.RecommendedTo;
//import lt.sdacademy.famtrip.services.RecommendedToService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/recommendedto")
//public class RecommendedToController {
//
//    private final RecommendedToService recommendedToService;
//
//    public RecommendedToController(RecommendedToService recommendedToService) {
//        this.recommendedToService = recommendedToService;
//    }
//
//    @GetMapping
//    public List<RecommendedTo> getRecommendedTos() {
//        return recommendedToService.getRecommendedTos();
//    }
//}
