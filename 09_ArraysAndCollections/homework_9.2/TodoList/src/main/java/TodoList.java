import java.util.ArrayList;

public class TodoList {
ArrayList<String> todList = new ArrayList<>();
    public void add(String todo) {
        todList.add(todo);
        System.out.println("Дело " + todo + " добавлено");
        // TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
      //  if(index<todList.size()&&index>=0) {
        if(index>=0 && index<=todList.size()) {
            todList.add(index, todo);
            System.out.println("Дело " + todo + " добавлено и присвоен " + index +" номер");
            }
        else
        if(index>todList.size()) {
            //index = todList.lastIndexOf(index);
            index = todList.size();
            todList.add(index, todo);
            System.out.println("Дело " + todo + " добавлено и присвоен " + index +" номер");
        }
//       }if(index>todList.size()) {
//            todList.ensureCapacity(todList.size()+1);
//            todList.add(index,todo);
//        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if(index<todList.size()&&index>=0) {
            System.out.println("Дело "+ todList.set(index, todo)  + " заменено на " + todList.get(index));
        }
        else{
        System.out.println("Дело с таким номером не существует");}
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if(index<todList.size()&&index>=0) {
            todList.remove(index);
            System.out.println("Дело с номером " + index + " удалено");
        }
        else{
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        int index=0;
        for (String temp:todList) {
            System.out.println(index +" - "+temp);
            index++;
        }
        return todList;
    }

}