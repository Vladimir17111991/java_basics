import net.sf.saxon.type.StringConverter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    Set<String> treeSet = new TreeSet<>();
    Map<String, String> map = new HashMap<>();
    //проверка на корректность ввода имени абонента
    public boolean checkName(String name) {
        boolean check = false;
        if (!name.isEmpty()) {
            String regName = "[А-Я][а-я]+";
            Pattern pattern = Pattern.compile(regName);
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                check = true;
            }
        }
        return check;
    }

    //проверка на корректность ввода номера телефона
    public boolean checkPhone(String phone) {

        if (!phone.isEmpty()) {
            String regPhone = "[7]\\d{10}";
            Pattern pattern = Pattern.compile(regPhone);
            Matcher matcher = pattern.matcher(phone);
            if (matcher.find()) {
                return true;
            } else
                return false;
        }
        return false;
    }

    //добавление контакта
    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (checkPhone(phone) && checkName(name)) {//если пройдена проверка на имя и телефон(для тестов)
            if (map.containsValue(phone)) {
                for (String oldName : map.keySet()) {
                    if (map.get(oldName).equals(phone)) {
                        map.replace(map.remove(oldName), name);
                        map.put(name, phone);
                        break;
                    }
                }
            } else if (map.containsKey(name)) {
                map.put(name, (map.get(name) + ", " + phone));//(для тестов)
            } else {
                map.put(name, phone);
            }
        } else if (checkName(name) && !checkPhone(phone)) {//если пройдена проверка на имя(с консоли посылаем имя)
            if (map.containsKey(name)) {//если ключ совпадает, то добавляем ему номер
                map.remove(name);
                map.put(name, (map.get(phone) + ", " + phone));
            } else if (!map.containsKey(name)) {//иначе делаем проверку,если такой номер существует, то меняем имя абонента
                for (String oldName : map.keySet()) {
                    if (map.get(oldName).equals(name)) {
                        map.replace(map.remove(oldName), name);
                        map.put(name, phone);
                        break;
                    }
                }
            }
        }
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String format = "";
        for (String key : map.keySet()) {
            if (map.get(key).equals(phone)) {
                format = key + " - " + map.get(key);
            }
        }
        return format;
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        String nameContact;
        for (Map.Entry entry : map.entrySet()) {
            if (!entry.getKey().toString().isEmpty()) {
                if (entry.getKey().toString().equals(name)) {
                    nameContact = entry.getKey().toString() + " - " + entry.getValue();
                    treeSet.add(nameContact);
                }
            }
        }
        return treeSet;
    }

    public Set<String> getAllContacts() {
        String format;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            format = entry.getKey() + " - " + entry.getValue();
            treeSet.add(format);
        }
        return treeSet;
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
    }
}
    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
