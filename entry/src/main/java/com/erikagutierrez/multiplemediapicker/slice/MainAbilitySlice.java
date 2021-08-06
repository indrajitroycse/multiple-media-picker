package com.erikagutierrez.multiplemediapicker.slice;

import com.erikagutierrez.multiplemediapicker.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.bundle.IBundleManager;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.security.SystemPermission;

/**
 * MainAbilitySlice contains Navigation to multiple media picker library.
 *
 * @since 2021-08-03
 */

public class MainAbilitySlice extends AbilitySlice {

    Button button;
    static final HiLogLabel LABEL = new HiLogLabel(HiLog.DEBUG, 0x00201, "Multiple_media_picker");

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        if (verifySelfPermission(
                SystemPermission.READ_USER_STORAGE) != IBundleManager.PERMISSION_GRANTED) {
            HiLog.info(LABEL, "Media permission getting 1");
            if (canRequestPermission(SystemPermission.READ_USER_STORAGE)) {
                requestPermissionsFromUser(new String[]{SystemPermission.READ_USER_STORAGE}, 0);
                HiLog.info(LABEL, "Media permission getting 2");
            }
        }

        button = (Button) findComponentById(ResourceTable.Id_btn_select_image);
        button.setClickedListener(listener ->
                openGallery());
    }

    public void openGallery() {
        present(new HomeAbilitySlice(), new Intent());
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
