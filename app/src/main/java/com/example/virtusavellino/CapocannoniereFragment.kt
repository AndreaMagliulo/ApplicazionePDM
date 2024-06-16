package com.example.virtusavellino

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment

class CapocannoniereFragment : Fragment() {
    data class Giocatore(
        val nome: String,
        val ruolo: String,
        val pres: Int,
        val gol: Int,
        val ast: Int
    )


    private lateinit var giocatori: MutableList<Giocatore>
    private lateinit var tableLayout: TableLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_capocannoniere, container, false)
        tableLayout = view.findViewById(R.id.tableLayout)

        // Popola la lista dei giocatori
        giocatori = mutableListOf(
            Giocatore("Di Benedetto Domenico", "ATT", 6, 2, 1),
            Giocatore("Ruggiero Alessandro", "CEN", 6, 2, 0),
            Giocatore("Cianci Francesco Pio", "ATT", 5, 2, 0),
            Giocatore("Serino Jacopo", "ATT", 4, 2, 1),
            Giocatore("Michele Alfieri", "CEN", 3, 2, 0),
            Giocatore("Cataldo Mathias", "DIF", 2, 2, 0),
            Giocatore("Marra Giuseppe", "CEN", 2, 0, 0),
            Giocatore("Morra Greco Lorenzo", "ATT", 2, 1, 0),
            Giocatore("Valentino Thomas", "ATT", 2, 1, 0),
            Giocatore("De Prisco Mario", "DIF", 1, 2, 0),
            Giocatore("Figliola Andrea", "ATT", 1, 2, 0),
            Giocatore("Giacomo Guerra", "CEN", 1, 2, 0),
            Giocatore("Magro Ciro", "ATT", 1, 0, 0),
            Giocatore("Mazzone Marco", "DIF", 1, 1, 0),
            Giocatore("Nigro Ciro", "DIF", 1, 2, 0)
        )

        // Popola la tabella inizialmente
        populateTable()

        // Imposta i listener di clic per le intestazioni delle colonne
        view.findViewById<TextView>(R.id.ruoloHeader).setOnClickListener {
            giocatori.sortBy { it.ruolo }
            populateTable()
        }

        view.findViewById<TextView>(R.id.golHeader).setOnClickListener {
            giocatori.sortByDescending { it.gol }
            populateTable()
        }

        view.findViewById<TextView>(R.id.presHeader).setOnClickListener {
            giocatori.sortByDescending { it.pres }
            populateTable()
        }

        view.findViewById<TextView>(R.id.astHeader).setOnClickListener {
            giocatori.sortByDescending { it.ast }
            populateTable()
        }

        return view
    }

    private fun populateTable() {
        // Rimuovi tutte le righe tranne l'intestazione
        tableLayout.removeViews(1, tableLayout.childCount - 1)

        for (giocatore in giocatori) {
            val tableRow = TableRow(context)
            tableRow.addView(createTextView(giocatore.nome))
            tableRow.addView(createTextView(giocatore.ruolo))
            tableRow.addView(createTextView(giocatore.pres.toString()))
            tableRow.addView(createTextView(giocatore.gol.toString()))
            tableRow.addView(createTextView(giocatore.ast.toString()))
            tableLayout.addView(tableRow)
        }
    }

    private fun createTextView(text: String): TextView {
        return TextView(context).apply {
            setPadding(8, 8, 8, 8)
            setText(text)
        }
    }
}
