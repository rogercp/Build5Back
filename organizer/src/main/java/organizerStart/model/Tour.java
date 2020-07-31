package organizerStart.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour")
public class Tour
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tourid;

//    @Column(nullable = false,
//            unique = false)
    private String tourname;

//    @Column(nullable = false,
//            unique = false)
    private String tourdescription;

//    @Column(nullable = false,
//            unique = true)
    private String tourguidephonenumber;

//    @Column(nullable = false,
//            unique = true)
    private long recommendedage;

//    @Column(nullable = false,
//            unique = true)
    private String whattobring;

//    @Column(nullable = false,
//            unique = true)
    private String category;

//    @Column(nullable = false,
//            unique = true)
    private String area;

//    @Column(nullable = false,
//            unique = true)
    private long price;

//    @Column(nullable = false,
//            unique = true)
    private long durationhrs;

//    @Column(nullable = false,
//            unique = true)
    private String meetingaddress;

//    @Column(nullable = false,
//            unique = true)
//    private long likes;

    @ManyToOne
    @JoinColumn(name="guideid")
    @JsonIgnoreProperties("tours")
    private Guide guide;

    @ManyToMany(mappedBy = "bookedtours",
            cascade = CascadeType.ALL
           )
    @JsonIgnoreProperties("tours")
    private List<Tourist> tourists= new ArrayList<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "favoritedtours", cascade = CascadeType.ALL
            )
    @JsonIgnoreProperties("tours")
    private List<Tourist> favoritedby= new ArrayList<>();

    public Tour()
    {
    }

    public Tour(String tourname)
    {
        this.tourname = tourname;
    }

    public Tour(String tourname, Guide guide)
    {
        this.guide = guide;
        this.tourname=tourname;
    }

    public Tour(String tourname, String tourdescription, String tourguidephonenumber, long recommendedage, String whattobring, String category, String area, long price, long durationhrs, String meetingaddress,  Guide guide)
    {
        this.tourname = tourname;
        this.tourdescription = tourdescription;
        this.tourguidephonenumber = tourguidephonenumber;
        this.recommendedage = recommendedage;
        this.whattobring = whattobring;
        this.category = category;
        this.area = area;
        this.price = price;
        this.durationhrs = durationhrs;
        this.meetingaddress = meetingaddress;
        this.guide = guide;
    }

    public List<Tourist> getFavoritedby()
    {
        return favoritedby;
    }

    public void setFavoritedby(List<Tourist> favoritedby)
    {
        this.favoritedby = favoritedby;
    }

    public long getTourid()
    {
        return tourid;
    }

    public void setTourid(long tourid)
    {
        this.tourid = tourid;
    }

    public String getTourname()
    {
        return tourname;
    }

    public void setTourname(String tourname)
    {
        this.tourname = tourname;
    }

    public String getTourdescription()
    {
        return tourdescription;
    }

    public void setTourdescription(String tourdescription)
    {
        this.tourdescription = tourdescription;
    }

    public long getRecommendedage()
    {
        return recommendedage;
    }

    public void setRecommendedage(long recommendedage)
    {
        this.recommendedage = recommendedage;
    }

    public String getWhattobring()
    {
        return whattobring;
    }

    public void setWhattobring(String whattobring)
    {
        this.whattobring = whattobring;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public long getPrice()
    {
        return price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }

    public long getDurationhrs()
    {
        return durationhrs;
    }

    public void setDurationhrs(long durationhrs)
    {
        this.durationhrs = durationhrs;
    }

    public String getMeetingaddress()
    {
        return meetingaddress;
    }

    public void setMeetingaddress(String meetingaddress)
    {
        this.meetingaddress = meetingaddress;
    }

    public Guide getGuide()
    {
        return guide;
    }

    public void setGuide(Guide guide)
    {
        this.guide = guide;
    }

    public List<Tourist> getTourists()
    {
        return tourists;
    }

    public void setTourists(List<Tourist> tourists)
    {
        this.tourists = tourists;
    }

    public String getTourguidephonenumber()
    {
        return tourguidephonenumber;
    }

    public void setTourguidephonenumber(String tourguidephonenumber)
    {
        this.tourguidephonenumber = tourguidephonenumber;
    }
}

































