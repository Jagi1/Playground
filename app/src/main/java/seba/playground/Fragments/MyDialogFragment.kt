package seba.playground.Fragments

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import seba.playground.R

class MyDialogFragment: DialogFragment(), View.OnClickListener {

    private lateinit var message: TextView
    private lateinit var yes: Button
    private lateinit var no: Button

    companion object {
        fun newInstance(message: String): MyDialogFragment {
            val fragment = MyDialogFragment()
            val args = Bundle()
            args.putString("message", message)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.myfragment,container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message = view.findViewById(R.id.message)
        yes = view.findViewById(R.id.yes)
        yes.setOnClickListener(this)
        no = view.findViewById(R.id.no)
        no.setOnClickListener(this)
        message.text = arguments?.getString("message")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.yes -> activity?.finish()
            R.id.no -> dialog.dismiss()
        }
    }

}