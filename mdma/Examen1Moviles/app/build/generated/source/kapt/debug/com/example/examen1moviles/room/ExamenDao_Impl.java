package com.example.examen1moviles.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ExamenDao_Impl implements ExamenDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ClientesEntity> __insertionAdapterOfClientesEntity;

  private final EntityDeletionOrUpdateAdapter<ConfiguraciónEntity> __updateAdapterOfConfiguraciónEntity;

  public ExamenDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClientesEntity = new EntityInsertionAdapter<ClientesEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `clientes` (`Id`,`salaElegida`,`palomitas`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final ClientesEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getSalaElegida());
        statement.bindLong(3, entity.getPalomitas());
      }
    };
    this.__updateAdapterOfConfiguraciónEntity = new EntityDeletionOrUpdateAdapter<ConfiguraciónEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `configuracion` SET `numSalas` = ?,`numAsientos` = ?,`precioPalomitas` = ? WHERE `numSalas` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final ConfiguraciónEntity entity) {
        statement.bindLong(1, entity.getNumSalas());
        statement.bindLong(2, entity.getNumAsientos());
        statement.bindDouble(3, entity.getPrecioPalomitas());
        statement.bindLong(4, entity.getNumSalas());
      }
    };
  }

  @Override
  public Object insertCliente(final ClientesEntity clientesEntity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfClientesEntity.insert(clientesEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateConfiguration(final ConfiguraciónEntity configuracion,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfConfiguraciónEntity.handle(configuracion);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAsientos(final Continuation<? super List<ConfiguraciónEntity>> continuation) {
    final String _sql = "SELECT * FROM configuracion";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ConfiguraciónEntity>>() {
      @Override
      @NonNull
      public List<ConfiguraciónEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNumSalas = CursorUtil.getColumnIndexOrThrow(_cursor, "numSalas");
          final int _cursorIndexOfNumAsientos = CursorUtil.getColumnIndexOrThrow(_cursor, "numAsientos");
          final int _cursorIndexOfPrecioPalomitas = CursorUtil.getColumnIndexOrThrow(_cursor, "precioPalomitas");
          final List<ConfiguraciónEntity> _result = new ArrayList<ConfiguraciónEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ConfiguraciónEntity _item;
            final int _tmpNumSalas;
            _tmpNumSalas = _cursor.getInt(_cursorIndexOfNumSalas);
            final int _tmpNumAsientos;
            _tmpNumAsientos = _cursor.getInt(_cursorIndexOfNumAsientos);
            final float _tmpPrecioPalomitas;
            _tmpPrecioPalomitas = _cursor.getFloat(_cursorIndexOfPrecioPalomitas);
            _item = new ConfiguraciónEntity(_tmpNumSalas,_tmpNumAsientos,_tmpPrecioPalomitas);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getSalas(final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT numSalas FROM configuracion";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getInt(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getSala(final int Id, final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT salaElegida FROM clientes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, Id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getInt(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
