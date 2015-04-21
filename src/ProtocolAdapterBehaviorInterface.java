public interface ProtocolAdapterBehaviorInterface {
    
    /**
     *
     * @param uri
     * @param data
     */
    public void start(String uri, GameData data);

    /**
     *
     * @param data
     */
    public void getOpponentMove(GameData data);

    
}
