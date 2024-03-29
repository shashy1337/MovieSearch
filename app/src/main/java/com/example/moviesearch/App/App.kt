package com.example.moviesearch.App

import android.app.Application
import com.example.moviesearch.Interfaces.RecyclerViewItems
import com.example.moviesearch.R
import com.example.moviesearch.model.FilmDataClass

class App : Application() {

    val filmDataBase = listOf(
        FilmDataClass("Back To The Future", R.drawable.backttf, "Marty McFly, a 17 year old high school student gets lost in 1955 by an accident, 30 years back in time. With the help of his friend Dr. Emmet Brown, he is desperately trying to find his way back to the future in the year 1985. It becomes a battle against the clock."),
        FilmDataClass("Pulp Fiction", R.drawable.fiction, "Pulp fiction refers to a genre of racy, action-based stories published in cheaply printed magazines from around 1900 to the 1950s, mostly in the United States. Pulp fiction gets its name from the paper it was printed on."),
        FilmDataClass("Jaws", R.drawable.jaws, "When a killer shark unleashes chaos on beach community off Long Island, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down. It's a hot summer on Amity Island, a small community whose main business is its beaches."),
        FilmDataClass("Jurasic Park", R.drawable.jurasic, "A pragmatic paleontologist touring an almost complete theme park on an island in Central America is tasked with protecting a couple of kids after a power failure causes the park's cloned dinosaurs to run loose. Huge advancements in scientific technology have enabled a mogul to create an island full of living dinosaurs."),
        FilmDataClass("Star Wars", R.drawable.sw, "The Star Wars franchise depicts the adventures of characters \"A long time ago in a galaxy far, far away\", in which humans and many species of aliens (often humanoid) co-exist with robots, or 'droids', who may assist them in their daily routines; space travel between planets is common due to lightspeed hyperspace ...")
    )

    val favList = mutableListOf<RecyclerViewItems>()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance : App
            private set
    }
}
