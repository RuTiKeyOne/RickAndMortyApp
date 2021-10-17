package com.example.rickandmortyapp.activities.commandpatter.parent;

import android.content.Context;
import android.content.Intent;

public abstract class BaseIntentCommand {
    public abstract Intent executeCommandActivity(Context context);
}
