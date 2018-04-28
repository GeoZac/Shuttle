package com.simplecity.amp_library.utils.menu.genre;

import android.content.Context;
import android.support.v7.widget.PopupMenu;

import com.simplecity.amp_library.R;
import com.simplecity.amp_library.model.Genre;
import com.simplecity.amp_library.utils.MusicUtils;
import com.simplecity.amp_library.utils.extensions.GenreExt;
import com.simplecity.amp_library.utils.menu.MenuUtils;

public class GenreMenuUtils {

    public interface Callbacks {

        void showToast(String message);

        void onPlaylistItemsInserted();

        void onQueueItemsInserted(String message);

        void playNext(Genre genre);
    }

    public static PopupMenu.OnMenuItemClickListener getGenreClickListener(Context context, Genre genre, Callbacks callbacks) {
        return item -> {
            switch (item.getItemId()) {
                case R.id.play:
                    MenuUtils.play(GenreExt.INSTANCE.getSongs(genre), callbacks::showToast);
                    return true;
                case R.id.playNext:
                    callbacks.playNext(genre);
                    return true;
                case MusicUtils.Defs.NEW_PLAYLIST:
                    MenuUtils.newPlaylist(context, GenreExt.INSTANCE.getSongs(genre), callbacks::onPlaylistItemsInserted);
                    return true;
                case MusicUtils.Defs.PLAYLIST_SELECTED:
                    MenuUtils.addToPlaylist(context, item, GenreExt.INSTANCE.getSongs(genre), callbacks::onPlaylistItemsInserted);
                    return true;
                case R.id.addToQueue:
                    MenuUtils.addToQueue(GenreExt.INSTANCE.getSongs(genre), callbacks::onQueueItemsInserted);
                    return true;
            }
            return false;
        };
    }
}
