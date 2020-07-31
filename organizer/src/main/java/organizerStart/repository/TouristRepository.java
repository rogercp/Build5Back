package organizerStart.repository;

import com.lambdaschool.wanderlust.model.Tourist;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TouristRepository extends CrudRepository<Tourist,Long>
{
//    List<Tourist> findByTouristNameContainingIgnoreCase(String name);

    @Modifying
    @Query(value = "INSERT INTO bookedtours(touristid, tourid) VALUES (:touristid, :tourid)", nativeQuery = true)
    void assignTouristToTour(long touristid, long tourid);


    @Modifying
    @Query(value = "INSERT INTO favoritedtours(touristid, tourid) VALUES (:touristid, :tourid)", nativeQuery = true)
    void addFavoritedTours(long touristid, long tourid);

    @Modifying
    @Query(value="DELETE FROM bookedtours WHERE tourid=:tourid",nativeQuery = true)
    void deleteTouristTourById(long tourid);

    @Modifying
    @Query(value = "DELETE FROM bookedtours WHERE touristid=:touristid",nativeQuery = true)
    void deleteTouristTourById2(long touristid);

    @Modifying
    @Query(value="DELETE FROM favoritedtours WHERE tourid=:tourid",nativeQuery = true)
    void deleteFavsTouristTourById(long tourid);

    @Modifying
    @Query(value = "DELETE FROM favoritedtours WHERE touristid=:touristid",nativeQuery = true)
    void deleteFavsTouristTourById2(long touristid);



}


