import client.ClientProvider;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneOptions;
import data.UserAccount;
import data.User;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class Service {

    private User user;
    MongoClient client = ClientProvider.getClient();
    MongoDatabase database = client.getDatabase("Bank");
    MongoCollection<User> userCollection = database.getCollection("user", User.class);


    public User getUser() {
        return user;
    }

    public User getLoginUser(String name, String surname) {
        User user = userCollection.find(and(eq("name", name), eq("surname", surname))).first();
        return user;
    }

    public void addUser() {
        Scanner scanner = new Scanner(System.in);
        User user;
        String name;
        String surname;
        System.out.println("Prasome prisiregistruoti");
        do {
            System.out.println("Iveskite varda");
            name = scanner.nextLine();
            System.out.println("Iveskite pavarde");
            surname = scanner.nextLine();
            user = getUser();
            if (user != null) {
                System.out.println("Toks vartotojas jau yra");
            }
        } while (user != null);

        System.out.println("Iveskite teefono numeri");
        String phone = scanner.nextLine();

        user = new User(null, name, surname, phone, null, null, null);
        userCollection.insertOne(user);
        System.out.printf("Sveikiname prisiregistravus %s %s%n ", name, surname);
    }


    public void createUsers() {
        List<User> users = List.of(new User(null, "Nisparas", "Alternatyviai", "+37067214633", Set.of(new UserAccount("Swedbank", "LT557300010000000036", 200.00))),
                new User(null, "Mantas", "Judzentis", "+37067314568", Set.of(new UserAccount("Luminor", "LT594010049500047594", 1450.00))));
        userCollection.insertMany(users);
    }

    public User accountBalance(String accountNumber, double balance) {

    }
}


