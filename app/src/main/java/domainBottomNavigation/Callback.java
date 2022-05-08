package domainBottomNavigation;
//Пишем Асинхронный метод
public interface Callback<T> {

    void onSuccess(T data); // будет передовать данные ( если запрос удачный )

    void onError(Throwable exception); // если все плохо то вызывается метод onError





}
