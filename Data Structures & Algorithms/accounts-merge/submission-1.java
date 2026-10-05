class Solution {
    private class Name {
        String name;
        Set<Email> emails;

        public Name(String name) {
            this.name = name;
            this.emails = new HashSet<>();
        }
    }

    private class Email {
        String email;
        Set<Name> owners;
        Name defaultOwner;

        public Email(String email, Name defaultOwner) {
            this.email = email;
            this.defaultOwner = defaultOwner;
            this.owners = new HashSet<>();
            this.owners.add(defaultOwner);
        }



    }

    private List<Name> names;
    private Map<String, Email> emails;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.names = new ArrayList<>();
        this.emails = new HashMap<>();
        for (List<String> account : accounts) {
            Name name = new Name(account.get(0));
            for (int i=1;i<account.size();i++) {
                String emailString = account.get(i);
                Email email = emails.getOrDefault(emailString, new Email(emailString, name));
                if (email.defaultOwner!=name) email.owners.add(name);
                emails.put(emailString, email);
                name.emails.add(email);
            }
            names.add(name);
        }

        for (Email email : emails.values()) {
            Name currentDefaultOwner = email.defaultOwner;
            for (Name otherOwners : email.owners) {
                if (currentDefaultOwner==otherOwners) continue;
                for (Email siblingEmails : otherOwners.emails) {
                    currentDefaultOwner.emails.add(siblingEmails);
                    siblingEmails.defaultOwner = currentDefaultOwner;
                }
            }
        }
        Set<Name> mainSet = new HashSet<>();
        for (Email email : emails.values()) mainSet.add(email.defaultOwner);
        List<List<String>> returnList = new ArrayList<>();
        for (Name name : mainSet) {
            List<String> currentMain = new ArrayList<>();
            currentMain.add(name.name);
            currentMain.addAll(name.emails.stream().map(e -> e.email).sorted().toList());
            returnList.add(currentMain);
        }

        return returnList;

    }
}