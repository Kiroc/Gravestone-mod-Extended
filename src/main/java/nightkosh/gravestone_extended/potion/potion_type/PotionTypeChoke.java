package nightkosh.gravestone_extended.potion.potion_type;

import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import nightkosh.gravestone_extended.core.GSPotion;
import nightkosh.gravestone_extended.core.ModInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PotionTypeChoke extends PotionType {

    public PotionTypeChoke(PotionEffect... effects) {
        super(effects);
        this.setRegistryName(ModInfo.ID, "gs_choke_type");
    }

    @Override
    public List<PotionEffect> getEffects() {
        List<PotionEffect> effectList = new ArrayList<>(1);
        effectList.add(new PotionEffect(GSPotion.CHOKE, 500));
        return effectList;
    }
}
