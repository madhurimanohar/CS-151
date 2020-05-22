package hw3;

public enum ChannelList {
    
    HGTV(101), CNN(102), DISCOVERYCHANNEL(103), NBC(104), ABC(105);
    
    private final int channelNum;
    
    private ChannelList(int cn) {
        channelNum = cn;
    }
    
    public int channelNum() {
        return channelNum;
    }
}
