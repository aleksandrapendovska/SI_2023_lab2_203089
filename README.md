# Александра Пендовска 203089

## 2. Central Flow Graph:

![si lab2 drawio](https://github.com/aleksandrapendovska/SI_2023_lab2_203089/assets/128921508/fd8438c1-3f07-483f-8567-df15034aa179)


## 3. Цикломатска комплексност:
Цикломатската комплексност на овој граф е 11. Ја пресметав со помош на формулата P + 1. P (предикатни јазли) е 10, 10 + 1 = 11.


## 4. Every Branch:
<img width="599" alt="every branchh" src="https://github.com/aleksandrapendovska/SI_2023_lab2_203089/assets/128921508/040af9cc-3de4-45a2-8130-ceb14b75c3f7">

**Прв тест:**
```
List<User> users = new ArrayList<>();
RuntimeException ex;
User user = null;
ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, users));
assertTrue(ex.getMessage().contains("Mandatory information missing!"));
```

**Втор тест:**
```
User user1 = new User(null, "Abc1234@!", "abc@gmail.com");
SILab2.function(user1, users);
assertEquals(user1.email, user1.getUsername());
```
Ако username е null програмата на негово место ја поставува вредноста на email. Затоа проверувам дали се еднакви.

**Трет тест:**
```
User user2 = new User("abc", "abcabcabc", "abcgmail.com");
SILab2.function(user2, users);
assertEquals(1, user2.getSame());
```
Бидејќи нема @ во email вредноста на same треба да остане 1.
**Морав да направам мали промени во кодот за да имплементирам getter за same**


**Четврти тест:**
```
User user4 = new User("abc", "abc$$abc%", "abc@gmail.com");
SILab2.function(user4, users);
assertEquals(0, user4.getSame());
```
Ако same има вредност 0 значи сите внесени вредности се во ред.

**Петти тест:**
```
users.add(user1);
users.add(user2);
User user3 = new User("abc", "abc$$abc%", "abc@gmail.com");
SILab2.function(user3, users);
assertEquals(2, user3.getSame());
```
same треба да е 2, бидејќи постои еден user со ист username и еден со ист email.

## 5. Multiple Condition
if(user==null || user.getPassword()==null || user.getEmail()==null)
**Possible conditions:**

1. T || X || X (user=null, password and email anything)
- null враќа true, па другите нема потреба да се проверуваат.

```
List<User> users = new ArrayList<>();
RuntimeException ex;
User user = null;
ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, users));
assertTrue(ex.getMessage().contains("Mandatory information missing!"));
```

2. F || T || X (user not null, password=null, email anything)
- user не е null односно е false, password е null односно true, email нема потреба да се проверува, може да биде било што.

```
User user1 = new User("abc", null, "abc@gmail.com");
ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
assertTrue(ex.getMessage().contains("Mandatory information missing!"));
```

3. F || F || T (user и password not null, email=null)
- user и password не се null односно се false, email е null односно true.

```
User user2 = new User("abc", "abc123", null);
ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
assertTrue(ex.getMessage().contains("Mandatory information missing!"));
```


4. F || F || F (сите not null)
- единствен случај во кој условот не е исполнет.

```
User user3 = new User("abcd", "Abc1234@!", "abcd@gmail.com");
assertTrue(SILab2.function(user3, users));
```
