package lt.sdacademy.famtrip.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

    @Entity
    @Table(name = "city")
    public class CityEntity extends AbstractEntity {

        @Column(name = "title", length = 50, nullable = false)
        private String title;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "title", nullable = false)
        private TitleEntity title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Column(name = "country_id", length = 50, nullable = false)
        private String country_id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "country_id", nullable = false)
        private CountryIdEntity countryId;

        public String getCountry_id() {
            return country_id;
        }

        public void setCountry_id(String country_id) {
            this.country_id = country_id;
        }

    }
}



