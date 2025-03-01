package com.example.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FlatEntity.Flat;
import com.example.FlatInterface.FlatDao;


@RestController
@RequestMapping("/api/flats")
public class AllMethods
{

    @Autowired
    private FlatDao flatDAO;
    
//=================================================================================

        // Add a new flat
      @PostMapping
      public Flat addFlat(@RequestBody Flat flat) {   	  
    	  System.out.println(flat);
          return flatDAO.save(flat);
          
      }
      
//		@PostMapping
//		public String addFlat(@RequestBody Flat flat) {
//			flatDAO.save(flat);
//			return "Flat added successfully!";
//		}
       
//        @PostMapping
//        public ResponseEntity<Flat> addFlat(@RequestBody Flat flat) {
//            Flat savedFlat = flatDAO.save(flat);
//            System.out.println(savedFlat);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedFlat);
//        }
    
//		@PostMapping
//		public ResponseEntity<String> addFlat(@RequestBody Flat flat) {
//		    flatDAO.save(flat);
//		    return ResponseEntity.status(HttpStatus.CREATED).body("Flat added successfully!");
//		}
    
//        @PostMapping
//        public ResponseEntity<String> addFlat(@RequestBody Flat flat) {
//            Flat savedFlat = flatDAO.save(flat);
//            return ResponseEntity.status(HttpStatus.CREATED)
//                                 .body("Flat added successfully with ID: " + savedFlat.getId());
//        }
    
//         @PostMapping
//         public ResponseEntity<String> addFlat(@RequestBody Flat flat) {
//           flatDAO.save(flat);
//           return ResponseEntity.status(HttpStatus.CREATED)
//                             .header("Custom-Header", "Flat-Creation")
//                             .body("Flat added successfully!");
//         }

//=================================================================================
        
         // Update an existing flat
//    @PutMapping("/{id}")
//    public ResponseEntity<Flat> updateFlat(@PathVariable Long id, @RequestBody Flat flat) {
//        Optional<Flat> existingFlat = flatDAO.findById(id);
//        
//        if (existingFlat.isPresent()) {
//            // If flat exists, update it
//            Flat updatedFlat = existingFlat.get();
//            updatedFlat.setFloorNumber(flat.getFloorNumber());
//            updatedFlat.setPrice(flat.getPrice());
//            updatedFlat.setIsAvailable(flat.getIsAvailable());
//            updatedFlat.setFurnishedStatus(flat.getFurnishedStatus());
//            updatedFlat.setNumberOfBalconies(flat.getNumberOfBalconies());
//            updatedFlat.setFlatType(flat.getFlatType());
//            updatedFlat.setFlatNumber(flat.getFlatNumber());
//            updatedFlat.setOwnerName(flat.getOwnerName());
//
//            // Save and return the updated flat
//            flatDAO.save(updatedFlat);
//            return ResponseEntity.ok(updatedFlat);// Return the updated flat with HTTP status OK (200)
//
////			return "Flat updated successfully!";   If we want to return this string/message then the method return type should be String and Flat
//
//        } else {
//            // If flat doesn't exist, return a not found response
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                 .body(null);//if here we want to print "flat not updated" the message in the body then method return type should be String
////          // Return NOT_FOUND status if the flat with the given id does not exist
//
//        }
//    }

        @PutMapping("/{id}")
        public ResponseEntity<Flat> updateFlat(@PathVariable Long id, @RequestBody Flat flat) {
            Optional<Flat> existingFlat = flatDAO.findById(id);

            if (existingFlat.isPresent()) {
                Flat updatedFlat = existingFlat.get();
                updatedFlat.setFloorNumber(flat.getFloorNumber());
                updatedFlat.setPrice(flat.getPrice());
                updatedFlat.setIsAvailable(flat.getIsAvailable());
                updatedFlat.setFurnishedStatus(flat.getFurnishedStatus());
                updatedFlat.setNumberOfBalconies(flat.getNumberOfBalconies());
                updatedFlat.setFlatType(flat.getFlatType());
                updatedFlat.setFlatNumber(flat.getFlatNumber());
                updatedFlat.setOwnerName(flat.getOwnerName());

                flatDAO.save(updatedFlat);
                return ResponseEntity.ok(updatedFlat);
            } else {
                throw new NoSuchElementException("Flat with ID " + id + " not found");
            }
        }
  

    
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateFlat(@PathVariable Long id, @RequestBody Flat flat) {
//        Flat existingFlat = flatDAO.findById(id).orElse(null);
//
//        if (existingFlat == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        existingFlat.setFlatNumber(flat.getFlatNumber());
//        existingFlat.setOwnerName(flat.getOwnerName());
//        existingFlat.setFloorNumber(flat.getFloorNumber());
//        existingFlat.setIsAvailable(flat.getIsAvailable());
//        existingFlat.setSquareFootage(flat.getSquareFootage());
//        existingFlat.setPrice(flat.getPrice());
//        existingFlat.setFurnishedStatus(flat.getFurnishedStatus());
//        existingFlat.setNumberOfBalconies(flat.getNumberOfBalconies());
//        existingFlat.setFlatType(flat.getFlatType());
//
//        Flat updatedFlat = flatDAO.save(existingFlat);
//        //return ResponseEntity.ok(updatedFlat);
//        return ResponseEntity.status(HttpStatus.CREATED)
//              .body("Flat updated successfully with ID: " + updatedFlat.getId());
//    }


//=================================================================================

        // Delete a flat
//        @DeleteMapping("/{id}")
//        public void deleteFlat(@PathVariable Long id) {
//            flatDAO.deleteById(id);
//        }	
        

//            @DeleteMapping("/{id}")
//            public ResponseEntity<String> deleteFlat(@PathVariable Long id) {
//                try {
//                    flatDAO.deleteById(id);
//                    return ResponseEntity.ok("Flat deleted successfully.");
//                } catch (EmptyResultDataAccessException ex) {
//                    throw new NoSuchElementException("Flat with ID " + id + " does not exist.");
//                }
//            }
        
         
//         @DeleteMapping("/{id}")
//         public String deleteFlat(@PathVariable Long id) {
//             flatDAO.deleteById(id);
//		  return "Flat Deleted Successfully";
//         }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteFlat(@PathVariable Long id) {
            flatDAO.deleteById(id);
            return ResponseEntity.ok("Flat deleted successfully");
        }

      
//        @DeleteMapping("/{id}")
//        public ResponseEntity<String> deleteFlat(@PathVariable Long id) {
//            if (flatDAO.existsById(id)) {
//                flatDAO.deleteById(id);
//                return ResponseEntity.ok("Flat deleted successfully");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flat not found");
//            }
//        }

          
//        @DeleteMapping("/{id}")
//        public ResponseEntity<Void> deleteFlat(@PathVariable Long id) {
//            if (flatDAO.existsById(id)) {
//                flatDAO.deleteById(id);
//                return ResponseEntity.noContent().build();
//                //204 No Content which indicates that the operation was successful but there is no data to return./no content in the response body. (i.e., no content to return).
//            } else {
//                return ResponseEntity.notFound().build();
//                // 404 Not Found , indicating that the resource was not found.
//            }
//        }

//=================================================================================

        // Get flat by ID
//        @GetMapping("/{id}")
//        public Flat getFlatById(@PathVariable Long id) {
//            return flatDAO.findById(id).orElseThrow(() -> new RuntimeException("Flat not found."));
//        }
        
//        @GetMapping("/{id}")
//        public Flat getFlatById(@PathVariable Long id) {
//            Optional<Flat> flat = flatDAO.findById(id);
//            if (flat.isPresent()) {
//                return flat.get();
//            } else {
//                return null; // Return null if not found
//            }
//        }
        
//        @GetMapping("/{id}")
//        public Flat getFlatById(@PathVariable Long id) {
//            return flatDAO.findById(id)
//                    .orElseThrow(() -> new ResourceNotFoundException("Flat not found with ID: " + id));
//        }

        
//        @GetMapping("/{id}")
//        public ResponseEntity<Flat> getFlatById(@PathVariable Long id) {
//            Optional<Flat> flat = flatDAO.findById(id);
//            
//            if (flat.isPresent()) {
//                return ResponseEntity.ok(flat.get());  // If flat is found, return it with 200 OK
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // If flat is not found, return 404 Not Found
//            }
//        }

        
//        @GetMapping("/{id}")
//        public ResponseEntity<String> getFlatById(@PathVariable Long id) {
//            Optional<Flat> flat = flatDAO.findById(id);
//            
//            if (flat.isPresent()) {
//                return ResponseEntity.ok("Flat found with ID: " + id);  // Return message with 200 OK
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flat not found with ID: " + id);  // Return message with 404 Not Found
//            }
//        }
        
//        @GetMapping("/{id}")
//        public ResponseEntity<Flat> getFlatById(@PathVariable Long id) {
//            Optional<Flat> flat = flatDAO.findById(id);
//
//            return flat.map(ResponseEntity::ok)
//                       .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
//        }

//=================================================================================

        // Get all flats
        @GetMapping
        public List<Flat> getAllFlats() {
            return flatDAO.findAll();
        }
        //Directly returns the list of flats.
        //The response will have the default HTTP status 200 OK.
      
//        @GetMapping
//        public ResponseEntity<List<Flat>> getAllFlats() {
//            List<Flat> flats = flatDAO.findAll();
//            return ResponseEntity.ok(flats);
//        }
        //Explicitly sets the HTTP status 200 OK using ResponseEntity.
  

//        @GetMapping
//        public ResponseEntity<List<Flat>> getAllFlats() {
//            List<Flat> flats = flatDAO.findAll();
//            if (flats.isEmpty()) {
//                return ResponseEntity.noContent().build();
//            }
//            return ResponseEntity.ok(flats);
//        }
        
//        @GetMapping
//        public ResponseEntity<?> getAllFlats() {   //? allows the method to return a ResponseEntity containing any type of body.[either flat obj or String]
//
//            List<Flat> flats = flatDAO.findAll();
//            if (flats.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flats available");
//            }
//            return ResponseEntity.ok(flats);
//        }

//=================================================================================

        // Get available flats
        @GetMapping("/available")
        public List<Flat> getAvailableFlats() {
            List<Flat> availableFlats = new ArrayList<>();
            for (Flat flat : flatDAO.findAll()) {
                if (flat.getIsAvailable()==1) {
                    availableFlats.add(flat);
                }
            }
            return availableFlats;
        }
        
//        @GetMapping("/available")
//        public ResponseEntity<List<Flat>> getAvailableFlats() {
//            List<Flat> availableFlats = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.isAvailable()) {
//                    availableFlats.add(flat);
//                }
//            }
//
//            if (availableFlats.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(availableFlats);
//            }
//            return ResponseEntity.ok(availableFlats);
//        }
        
//        @GetMapping("/available")
//        public List<Flat> getAvailableFlats() {
//            List<Flat> availableFlats = new ArrayList<>();
//            Iterator<Flat> iterator = flatDAO.findAll().iterator();
//
//            while (iterator.hasNext()) {
//                Flat flat = iterator.next();
//                if (flat.isAvailable()) {
//                    availableFlats.add(flat);
//                }
//            }
//            return availableFlats;
//        }
        
//        @GetMapping("/available")
//        public ResponseEntity<List<Flat>> getAvailableFlats() {
//            List<Flat> availableFlats = flatDAO.findAll()
//                                               .stream()
//                                               .filter(Flat::isAvailable)
//                                               .toList();
//            return ResponseEntity.ok(availableFlats);
//        }

//=================================================================================

        // Get flats by floor number
        @GetMapping("/floor/{floorNumber}")
        public List<Flat> getFlatsByFloorNumber(@PathVariable int floorNumber) {
            List<Flat> flatsByFloor = new ArrayList<>();
            for (Flat flat : flatDAO.findAll()) {
                if (flat.getFloorNumber() == floorNumber) {
                    flatsByFloor.add(flat);
                }
            }
            return flatsByFloor;
        }
        
//        @GetMapping("/floor/{floorNumber}")
//        public ResponseEntity<List<Flat>> getFlatsByFloorNumber(@PathVariable int floorNumber) {
//            List<Flat> flatsByFloor = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getFloorNumber() == floorNumber) {
//                    flatsByFloor.add(flat);
//                }
//            }
//            if (flatsByFloor.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(flatsByFloor);
//            }
//            System.out.println(flatsByFloor);
//            return ResponseEntity.ok(flatsByFloor);
//        }
        
//        @GetMapping("/floor/{floorNumber}")
//        public ResponseEntity<String> getFlatsByFloorNumber(@PathVariable int floorNumber) {
//            List<Flat> flatsByFloor = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getFloorNumber() == floorNumber) {
//                    flatsByFloor.add(flat);
//                }
//            }
//            return flatsByFloor.isEmpty() ? 
//                   ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flats found on floor " + floorNumber) 
//                   : ResponseEntity.ok("Found " + flatsByFloor.size() + " flat(s) on floor " + floorNumber);
//        }
        
//        @GetMapping("/floor/{floorNumber}")
//        public String getFlatsByFloorNumber(@PathVariable int floorNumber) {
//            List<Flat> flatsByFloor = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getFloorNumber() == floorNumber) {
//                    flatsByFloor.add(flat);
//                }
//            }
//            return flatsByFloor.isEmpty() ? 
//                   "No flats found on floor " + floorNumber 
//                   : "Found " + flatsByFloor.size() + " flat(s) on floor " + floorNumber;
//        }
        
//        @GetMapping("/floor/{floorNumber}")
//        public List<Flat> getFlatsByFloorNumber(@PathVariable int floorNumber) {
//            List<Flat> flatsByFloor = new ArrayList<>();
//            Iterator<Flat> iterator = flatDAO.findAll().iterator();
//            while (iterator.hasNext()) {
//                Flat flat = iterator.next();
//                if (flat.getFloorNumber() == floorNumber) {
//                    flatsByFloor.add(flat);
//                }
//            }
//            return flatsByFloor;
//        }

//        @GetMapping("/floor/{floorNumber}")
//        public String getFlatDetailsOnFloor(@PathVariable int floorNumber) {
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getFloorNumber() == floorNumber) {
//                    return "Flat found: " + flat.toString();
//                }
//            }
//            return "No flats found on floor " + floorNumber;
//        }
     
//        @GetMapping("/floor/{floorNumber}")
//        public ResponseEntity<List<Flat>> getFlatsByFloorNumber(@PathVariable int floorNumber) {
//            List<Flat> flatsByFloor = flatDAO.findAll().stream()
//                                             .filter(flat -> flat.getFloorNumber() == floorNumber)
//                                             .toList();
//            return ResponseEntity.ok(flatsByFloor);
//        }

//=================================================================================

        // Get furnished flats
//        @GetMapping("/furnished/{status}")
//        public List<Flat> getFurnishedFlats(@PathVariable String status) {
//            List<Flat> furnishedFlats = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getFurnishedStatus().equalsIgnoreCase(status)) {
//                    furnishedFlats.add(flat);
//                }
//            }
//            return furnishedFlats;
//        }
        
//        @GetMapping("/furnished/{status}")
//        public ResponseEntity<List<Flat>> getFurnishedFlats(@PathVariable String status) {
//            List<Flat> furnishedFlats = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getFurnishedStatus().equalsIgnoreCase(status)) {
//                    furnishedFlats.add(flat);
//                }
//            }
//            return furnishedFlats.isEmpty() ?
//                   ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) :
//                   ResponseEntity.ok(furnishedFlats);
//        }
//        @GetMapping("/furnished/{status}")
//        public String getFurnishedFlats(@PathVariable String status) {
//            List<Flat> furnishedFlats = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getFurnishedStatus().equalsIgnoreCase(status)) {
//                    furnishedFlats.add(flat);
//                }
//            }
//            return furnishedFlats.isEmpty() ?
//                   "No flats found with furnished status: " + status :
//                   "Found " + furnishedFlats.size() + " flat(s) with furnished status: " + status;
//        }


        @GetMapping("/furnished/{status}")
        public ResponseEntity<List<Flat>> getFurnishedFlats(@PathVariable String status) {
            List<Flat> furnishedFlats = flatDAO.findAll()
                                               .stream()
                                               .filter(flat -> flat.getFurnishedStatus().equalsIgnoreCase(status))
                                               .toList();
            return ResponseEntity.ok(furnishedFlats);
        }

//=================================================================================

        // Get flats by price range
//        @GetMapping("/price")
//        public List<Flat> getFlatsByPriceRange(@RequestParam double min, @RequestParam double max) {
//            List<Flat> flatsInPriceRange = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getPrice() >= min && flat.getPrice() <= max) {
//                    flatsInPriceRange.add(flat);
//                }
//            }
//            return flatsInPriceRange;
//        }
        
//        @GetMapping("/price")
//        public List<Flat> getFlatsByPriceRange(@RequestParam double min, @RequestParam double max) {
//            List<Flat> flatsInPriceRange = new ArrayList<>();
//            Iterator<Flat> iterator = flatDAO.findAll().iterator();
//            while (iterator.hasNext()) {
//                Flat flat = iterator.next();
//                if (flat.getPrice() >= min && flat.getPrice() <= max) {
//                    flatsInPriceRange.add(flat);
//                }
//            }
//            return flatsInPriceRange;
//        }
        
//        @GetMapping("/price")
//        public ResponseEntity<List<Flat>> getFlatsByPriceRange(@RequestParam double min, @RequestParam double max) {
//            List<Flat> flatsInPriceRange = new ArrayList<>();
//            for (Flat flat : flatDAO.findAll()) {
//                if (flat.getPrice() >= min && flat.getPrice() <= max) {
//                    flatsInPriceRange.add(flat);
//                }
//            }
//            if (flatsInPriceRange.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//            }
//            return ResponseEntity.ok(flatsInPriceRange);
//        }
        
//        @GetMapping("/price")
//        public List<Flat> getFlatsByPriceRange(@RequestParam double min, @RequestParam double max) {
//            List<Flat> flatsInPriceRange = new ArrayList<>();
//            List<Flat> allFlats = flatDAO.findAll();
//            
//            for (Flat flat : allFlats) {
//                double price = flat.getPrice();
//                if (price >= min && price <= max) {
//                    flatsInPriceRange.add(flat);
//                }
//            }
//            return flatsInPriceRange;
//        }
        @GetMapping("/price")
        public ResponseEntity<?> getFlatsByPriceRange(@RequestParam double min, @RequestParam double max) {
            List<Flat> flatsInPriceRange = new ArrayList<>();
            for (Flat flat : flatDAO.findAll()) {
                if (flat.getPrice() >= min && flat.getPrice() <= max) {
                    flatsInPriceRange.add(flat);
                }
            }
            if (flatsInPriceRange.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flats available in the specified price range.");
            }
            return ResponseEntity.ok(flatsInPriceRange);
        }

//        @GetMapping("/price")
//        public ResponseEntity<List<Flat>> getFlatsByPriceRange(@RequestParam double min, @RequestParam double max) {
//            List<Flat> flatsByPriceRange = flatDAO.findAll().stream()
//                                                  .filter(flat -> flat.getPrice() >= min && flat.getPrice() <= max)
//                                                  .toList();
//            return ResponseEntity.ok(flatsByPriceRange);
//        }
    }





