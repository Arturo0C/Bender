/*int count = 0;
        while (mapa2d[v][h] != '$') {
            if (count % 2 == 0) {

                if (mapa2d[v + 1][h] != '#') {
                    if (mapa2d[v + 1][h] == 'I') { count++; }

                    movimientos.append("S");
                    v++;

                    if (mapa2d[v + 1][h] == '$') { movimientos.append("S");break; }

                } else if (mapa2d[v][h + 1] != '#') {
                    if (mapa2d[v][h + 1] == 'I') { count++; }

                    movimientos.append("E");
                    h++;

                    if (mapa2d[v][h + 1] == '$') { movimientos.append("E");break; }

                } else if (mapa2d[v - 1][h] != '#') {
                    if (mapa2d[v - 1][h] == 'I') { count++; }

                    movimientos.append("N");
                    v--;

                    if (mapa2d[v - 1][h] == '$') { movimientos.append("N");break; }

                } else if (mapa2d[v][h - 1] != '#') {
                    if (mapa2d[v][h - 1] == 'I') { count++; }

                    movimientos.append("W");
                    h--;

                    if (mapa2d[v][h - 1] == '$') { movimientos.append("W");break; }
                }
            } else {
                while (mapa2d[v][h] != '$') {

                    if (mapa2d[v - 1][h] != '#') {
                        if (mapa2d[v - 1][h] == 'I') { count++; }

                        movimientos.append("N");
                        v--;

                        if (mapa2d[v - 1][h] == '$') { break; }

                    } else if (mapa2d[v][h - 1] != '#') {
                        if (mapa2d[v][h - 1] == 'I') { count++; }

                        movimientos.append("W");
                        h--;

                        if (mapa2d[v][h - 1] == '$') { break; }

                    } else if (mapa2d[v + 1][h] != '#') {
                        if (mapa2d[v + 1][h] == 'I') { count++; }

                        movimientos.append("S");
                        v++;

                        if (mapa2d[v + 1][h] == '$') { break; }

                    } else if (mapa2d[v][h + 1] != '#') {

                        movimientos.append("E");
                        h++;

                        if (mapa2d[v][h + 1] == '$') { break; }

                    }
                }
            }
        }*/