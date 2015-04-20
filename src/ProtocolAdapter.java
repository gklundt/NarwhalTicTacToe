/**
 *
 */
public class ProtocolAdapter extends AbstractProtocolAdapter {

    private final ProtocolAdapterBehaviorInterface pabi;

    /**
     *
     */
    public ProtocolAdapter() {
        this.pabi = new RestProtocolAdapterBehavior();
    }

    /**
     * @param uri
     * @param data
     */
    @Override
    public void start(String uri, GameData data) {
        this.pabi.start(uri, data);
    }

    /**
     * @param data
     */
    @Override
    public void getOpponentMove(GameData data) {
        this.pabi.getOpponentMove(data);
    }
}
