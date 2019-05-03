package com.s4n.animaciones


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rect.setOnClickListener {
            smallImage.animate().apply {
                translationX(it.x)
                translationY(40f)

            }
        }
        smallImage.setOnClickListener {

            val extras = FragmentNavigatorExtras(
                smallImage to smallImage.transitionName
            )
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_blankFragment, null, null, extras)
        }

    }


}
