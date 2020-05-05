package.com.example.tutorialapp.controller;

import com.example.tutorialapp.model.Tutorial;
import com.example.tutorialapp.model.TutorialController;

@CrossOrigin(origins = "http://localhost:8081"

@RestController
@RequestMapping ("/api")
public class TutorialController {

    @Autowired
        TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
        public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required=false)String title){
            try {
                List<Tutorial> tutorials=new ArrayList<Tutorial>();
                if (id==null)
                    tutorialRepository.findAll().forEach(tutorials::add);
                else
                    tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

                if(tutorial.isEmpty()){
                    return new ResponseEntity<>(HttpStatus:NO_CONTENT); 
                }
                return new ResponseEntity<>(tutorials,HttpStatus.OK)
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @GetMapping("/tutorials/{id}")
        public ResponseEntity<List<Tutorial>> getTutorialsById(@PathVariable("id") String id){
            Optional<Tutorial> tutorialData=tutorialRepository.findById(id);

            if(tutorialData.isPresent()){
                return new ResponseEntity<>(tutorialData.get(),HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    @PostMapping("/tutorials")
        public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
             }try {
                Tutorial _tutorial=TutorialRepository.save(new Tutorial(tutorial.getTitle(),tutorial.getDescription(),false));
                return new ResponseEntity<>(_tutorial,HttpStatus.CREATED);
             } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
             }
        }
    
    @PutMapping("/tutorials/{id}")
        public ResponseEntity<Tutorial> updateTutorial(@PathVariable ("id") String id, @RequestBody Tutorial tutorial){

        }

    @DeleteMapping("/tutorials/{id}")
        public ResponseEntity<Tutorial> deleteTutorial(@PathVariable ("id") String id){

        }

    @DeleteMapping("/tutorials")
        public ResponseEntity<HttpStatus> deleteAllTutorials(){

        }

    @GetMapping("/tutorials/published")
        public ResponseEntity<List<Tutorial>> findByPublished(){
            try {
                List<Tutorial> tutorials= tutorialRepository.findByPublished(true);

                if(tutorials.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(tutorials,HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
}