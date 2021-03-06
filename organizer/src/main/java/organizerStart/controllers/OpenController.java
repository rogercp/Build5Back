package organizerStart.controllers;


import organizerStart.model.User;
import organizerStart.model.UserRoles;
import organizerStart.services.RoleService;
import organizerStart.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
public class OpenController
{

//    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/createnewtourist", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewTourist(HttpServletRequest request, @Valid
    @RequestBody
            User newuser) throws URISyntaxException
    {
//        logger.trace(request.getRequestURI() + " accessed");

        ArrayList<UserRoles> newRoles = new ArrayList<>();
        newRoles.add(new UserRoles(newuser, roleService.findByName("tourist")));
        newuser.setUserRoles(newRoles);

        newuser =  userService.save(newuser);

        // set the location header for the newly created resource - to another controller!
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder
                .fromUriString(request.getServerName() + ":" + request.getLocalPort() + "/users/user/{userId}")
                .buildAndExpand(newuser.getUserid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);


        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @PostMapping(value = "/createnewguide", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewGuide(HttpServletRequest request, @Valid
    @RequestBody
            User newuser) throws URISyntaxException
    {
//        logger.trace(request.getRequestURI() + " accessed");

        ArrayList<UserRoles> newRoles = new ArrayList<>();
        newRoles.add(new UserRoles(newuser, roleService.findByName("guide")));
        newuser.setUserRoles(newRoles);

        newuser =  userService.save(newuser);

        // set the location header for the newly created resource - to another controller!
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder
                .fromUriString(request.getServerName() + ":" + request.getLocalPort() + "/users/user/{userId}")
                .buildAndExpand(newuser.getUserid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);


        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}
