    package Model;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import Model.AddressBook;
    import Model.BuddyInfo;

    @Controller
    @RequestMapping(method = RequestMethod.GET)
    public class AddressBookController {
        private AddressBookRepo addressBookRepository;
        private BuddyInfoRepo buddyInfoRepository;

        private AddressBook ab;

        @Autowired
        public AddressBookController(AddressBookRepo addressBookRepository, BuddyInfoRepo buddyInfoRepository) {
            this.addressBookRepository = addressBookRepository;
            this.buddyInfoRepository = buddyInfoRepository;
        }


        @GetMapping("/")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            model.addAttribute("BuddyInfo", new BuddyInfo());
            if (addressBookRepository.count() == 0){
                AddressBook ab = new AddressBook();
                ab.setName("ab1");
                BuddyInfo b1 = new BuddyInfo("Jack", "416-525-4070",ab, "lakeshore rd");
                BuddyInfo b2 = new BuddyInfo("Chloe", "416-234-1234", ab, "east way rd");
                ab.addBuddy(b1);
                ab.addBuddy(b2);
                model.addAttribute("addressbook", ab);
                addressBookRepository.save(ab);
            }else{
                AddressBook addressBook = addressBookRepository.findById(Long.valueOf(0)).get();
                model.addAttribute("addressbook", addressBook);
            }

            return "addressBook";
        }


        @PostMapping("/Add")
        public String buddySubmit(@ModelAttribute("buddy") BuddyInfo buddyInfo, Model model) {
            AddressBook addressBook = addressBookRepository.findById(Long.valueOf(0)).get();
            model.addAttribute("BuddyInfo", new BuddyInfo());
            addressBook.addBuddy(buddyInfo);
            buddyInfoRepository.save(buddyInfo);
            addressBookRepository.save(addressBook);
            model.addAttribute("addressbook", addressBook);
            return "addressBook";
        }


    }

