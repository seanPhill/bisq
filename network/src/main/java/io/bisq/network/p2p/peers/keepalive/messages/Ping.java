package io.bisq.network.p2p.peers.keepalive.messages;

import io.bisq.common.app.Version;
import io.bisq.generated.protobuffer.PB;
import io.bisq.network.p2p.Msg;

public final class Ping extends KeepAliveMsg {
    // That object is sent over the wire, so we need to take care of version compatibility.
    private static final long serialVersionUID = Version.P2P_NETWORK_VERSION;

    public final int nonce;
    public final int lastRoundTripTime;

    public Ping(int nonce, int lastRoundTripTime) {
        this.nonce = nonce;
        this.lastRoundTripTime = lastRoundTripTime;
    }

    @Override
    public PB.Envelope toProto() {
        PB.Envelope.Builder baseEnvelope = Msg.getBaseEnvelope();
        return baseEnvelope.setPing(baseEnvelope.getPingBuilder()
                .setNonce(nonce)
                .setLastRoundTripTime(lastRoundTripTime)).build();
    }

    @Override
    public String toString() {
        return "Ping{" +
                ", nonce=" + nonce +
                "} " + super.toString();
    }
}
