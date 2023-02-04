
@FunctionalInterface
public interface OrderFilterInterface {
    boolean orderFilter(Order order, String wordToSearch);
}
