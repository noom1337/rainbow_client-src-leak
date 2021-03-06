package slavikcodd3r.rainbow.module.modes;

import slavikcodd3r.rainbow.event.events.BlockCullEvent;
import slavikcodd3r.rainbow.event.events.BoundingBoxEntityEvent;
import slavikcodd3r.rainbow.event.events.BoundingBoxEvent;
import slavikcodd3r.rainbow.event.events.MoveEvent;
import slavikcodd3r.rainbow.event.events.PacketReceiveEvent;
import slavikcodd3r.rainbow.event.events.PacketSendEvent;
import slavikcodd3r.rainbow.event.events.PushOutOfBlocksEvent;
import slavikcodd3r.rainbow.event.events.UpdateEvent;
import slavikcodd3r.rainbow.module.Module;
import slavikcodd3r.rainbow.option.Option;
import slavikcodd3r.rainbow.option.OptionManager;
import slavikcodd3r.rainbow.option.types.BooleanOption;

public class VelocityMode extends BooleanOption
{
    public VelocityMode(final String name, final boolean value, final Module module) {
        super(name, name, value, module);
    }
    
    @Override
    public void setValue(final Boolean value) {
        if (value) {
            for (final Option option : OptionManager.getOptionList()) {
                if (option.getModule().equals(this.getModule()) && option instanceof VelocityMode) {
                    ((BooleanOption)option).setValueHard(false);
                }
            }
        }
        else {
            for (final Option option : OptionManager.getOptionList()) {
                if (option.getModule().equals(this.getModule()) && option instanceof VelocityMode && option != this) {
                    ((BooleanOption)option).setValueHard(true);
                    break;
                }
            }
        }
        super.setValue(value);
    }
    
    public boolean enable() {
        return this.getValue();
    }
    
    public boolean onUpdate(final UpdateEvent event) {
        return this.getValue();
    }
    
    public boolean onPacket(final PacketSendEvent event) {
        return this.getValue();
    }
    
    public boolean onPacket(final PacketReceiveEvent event) {
        return this.getValue();
    }
    
    public boolean onMove(final MoveEvent event) {
        return this.getValue();
    }    
    
    public boolean onBB(final BoundingBoxEntityEvent event) {
        return this.getValue();
    }
    
    public boolean onBoundingBox(final BoundingBoxEvent event) {
    	return this.getValue();
    }
    
    public boolean onPushOutOfBlocks(final PushOutOfBlocksEvent event) {
    	return this.getValue();
    }
    
    public boolean onBlockCull(final BlockCullEvent event) {
    	return this.getValue();
    }
    
    public boolean disable() {
        return true;
    }
}
