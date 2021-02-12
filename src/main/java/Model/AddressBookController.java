    package Model;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import Model.AddressBook;
    import Model.BuddyInfo;

    @Controller
    public class AddressBookController {

        private AddressBook ab;


        @GetMapping("/")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            AddressBook ab = new AddressBook();
            ab.setName("ab1");
            BuddyInfo b1 = new BuddyInfo("Jack", "416-525-4070",ab);
            BuddyInfo b2 = new BuddyInfo("Chloe", "416-234-1234", ab);
            ab.addBuddy(b1);
            ab.addBuddy(b2);
            if (ab != null){
                model.addAttribute("addressbook", ab);
                return "addressBook";
            }else{
                return "greeting";
            }

        }


    }

