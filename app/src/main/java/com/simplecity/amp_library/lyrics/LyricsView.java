package com.simplecity.amp_library.lyrics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.simplecity.amp_library.model.Song;

interface LyricsView {

    void updateLyrics(@Nullable String lyrics);

    void showNoLyricsView(boolean show);

    void showQuickLyricInfoButton(boolean show);

    void showQuickLyricInfoDialog();

    void downloadQuickLyric();

    void launchQuickLyric(@NonNull Song song);
}
