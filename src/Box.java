public class Box<T> {
    private T obj;
    private boolean isEmpty; // коробка пуста

    public void setObj(T newobj) {
        if (newobj == null) {
            throw new IllegalArgumentException("Такое значение установить нельзя, введите ненулевое значение");
        }
        if (!isEmpty) {
            throw new IllegalStateException("В коробке нет места");
        }
        this.obj = newobj;
        isEmpty = false;
    }

    public T getObj() {
        if (isEmpty) {
            throw new IllegalStateException("В коробке нет объектов");
        }
        T nobj = this.obj;
        this.obj = null;
        isEmpty = true;
        return nobj;
    }

    public Box() {
        this.obj = null;
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        if (isEmpty){
            return "В коробке нет объектов";
        }
        return "В коробке хранится объект " + obj.toString();
    }
}
