package com.erikagutierrez.multiplemediapicker;

import com.erikagutierrez.multiplemediapicker.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

/**
 * MainAbility .
 *
 * @since 2021-08-03
 */

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
