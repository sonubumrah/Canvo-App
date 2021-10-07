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
 * Use the [CK.newInstance] factory method to
 * create an instance of this fragment.
 */
class CK : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var editText: EditText
    lateinit var btnNext:Button
    lateinit var txtans:TextView
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
        val view= inflater.inflate(R.layout.fragment_c_k, container, false)
        editText=view.findViewById(R.id.edtCK)
        btnNext=view.findViewById(R.id.btnNextCK)
        txtans=view.findViewById(R.id.txtCK)

            btnNext.setOnClickListener {
                if(editText.text.toString()!="") {
                    txtans.text = (editText.text.toString().toInt() + 273).toString()
                }
                else{
                    Toast.makeText(activity, "Enter Valid input", Toast.LENGTH_SHORT).show()
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
         * @return A new instance of fragment CK.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CK().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}