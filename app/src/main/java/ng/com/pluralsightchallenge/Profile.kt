package ng.com.pluralsightchallenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val image: ImageView = findViewById(R.id.imageView)

        Glide.with(this)
                .load("https://res.cloudinary.com/emkaydauda/image/upload/c_fit,h_574,q_100,r_0,w_574/v1557466852/official_photo.jpg")
                .into(image)
    }
}
