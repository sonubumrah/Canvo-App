package com.sonu.convo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FC.newInstance] factory method to
 * create an instance of this fragment.
 */
class FC : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var edtText:EditText
    lateinit var btnFC:Button
    lateinit var txtFC:TextView
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_f_c, container, false)
        edtText=view.findViewById(R.id.edtFC)
        btnFC=view.findViewById(R.id.btnNextFC)
        txtFC=view.findViewById(R.id.txtFC)

            btnFC.setOnClickListener {
                if(edtText.text.toString()!="") {


                    txtFC.text = ((edtText.text.toString().toInt() - 32) * 0.56).toString()
                }
                else{
                    Toast.makeText(activity, "Enter Valid Input", Toast.LENGTH_SHORT).show()
                }
            }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FC.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FC().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}