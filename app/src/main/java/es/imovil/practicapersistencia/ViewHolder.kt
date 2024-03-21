package es.imovil.practicapersistencia

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import es.imovil.practicapersistencia.databinding.ItemViewBinding

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Inicializamos la clase vinculada en el viewholder
    private val itemViewBinding = ItemViewBinding.bind(itemView)

    fun bind(book: Book) {
        with(itemViewBinding) {
            author.text = book.author
            title.text = book.title
            isbn.text = book.isbn ?: ""
            editorial.text = book.editorial ?: ""
            price.text = book.price.toString()
        }
    }
}
