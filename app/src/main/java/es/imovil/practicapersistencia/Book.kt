package es.imovil.practicapersistencia

import androidx.recyclerview.widget.DiffUtil

data class Book(var title:String,
                var author:String,
                // numero de libro
                var isbn:String? = null,
                var editorial:String? = null,
                var price:Float) {

    object DIFF_CALLBACK: DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            //checamos el numero de identificacion de los libros
            return oldItem.isbn == newItem.isbn
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            //camparamos el viejo objeto con el nuevo objeto
            return oldItem == newItem
        }

    }
}
