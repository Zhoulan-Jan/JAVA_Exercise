package eighteen;

public class Test {
    public static void main(String[] args) {
        GraphicsCard graphicsCard = new GraphicsCard();
        SoundCard soundCard = new SoundCard();
        NetworkCard networkCard = new NetworkCard();
        graphicsCard.Card();
        soundCard.Card();
        networkCard.Card();

        PCI pci = new GraphicsCard(); //创建一个接口的引用，对应到一个子类的实例
        pci.Card();

        PCI pci2 = new SoundCard();
        pci2.Card();

        PCI pci3 = new NetworkCard();
        pci3.Card();
    }
}
