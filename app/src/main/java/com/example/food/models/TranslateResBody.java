package com.example.food.models;

public class TranslateResBody {
    final String folder_id;
    final String targetLanguageCode;
    final String[] texts;

    public TranslateResBody(String folderId, String targetLanguageCode, String[] texts) {
        this.targetLanguageCode = targetLanguageCode;
        this.folder_id = folderId;
        this.texts = texts;
    }
}
