package com.example.home.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.presentation.LettersRecycleViewAdapter
import com.example.home.model.Sizes
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycleView: RecyclerView = binding.recycleviewId
        // added data from arraylist to adapter class.
        val adapter  = LettersRecycleViewAdapter(Sizes.row,this)
        val layoutManager  = GridLayoutManager(context, Sizes.columns);
        recycleView.layoutManager=layoutManager;
        recycleView.adapter=adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}