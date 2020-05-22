package hw3;

public class Television {

    public static void changeChannel(ChannelList c) {
        switch(c) {
        case HGTV:
            System.out.println("Changing the channgel to " + c + " " + Integer.toString(c.channelNum()));
            break;
        case CNN:
            System.out.println("Changing the channgel to " + c + " " + Integer.toString(c.channelNum()));
            break;
        case DISCOVERYCHANNEL:
            System.out.println("Changing the channgel to " + c + " " + Integer.toString(c.channelNum()));
            break;
        case NBC:
            System.out.println("Changing the channgel to " + c + " " + Integer.toString(c.channelNum()));
            break;
        case ABC:
            System.out.println("Changing the channgel to " + c + " " + Integer.toString(c.channelNum()));
            break;
        }
    }
    
    public static void main(String args[]) {
        ChannelList hgtv = ChannelList.HGTV;
        Television.changeChannel(hgtv);
        
        ChannelList cnn = ChannelList.CNN;
        Television.changeChannel(cnn);
        
        ChannelList dc = ChannelList.DISCOVERYCHANNEL;
        Television.changeChannel(dc);
        
        ChannelList nbc = ChannelList.NBC;
        Television.changeChannel(nbc);
        
        ChannelList abc = ChannelList.ABC;
        Television.changeChannel(abc);
    }
}
