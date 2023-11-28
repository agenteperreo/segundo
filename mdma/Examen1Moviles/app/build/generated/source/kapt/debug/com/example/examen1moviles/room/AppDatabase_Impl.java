package com.example.examen1moviles.room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ExamenDao _examenDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `clientes` (`Id` INTEGER NOT NULL, `salaElegida` INTEGER NOT NULL, `palomitas` INTEGER NOT NULL, PRIMARY KEY(`Id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `configuracion` (`numSalas` INTEGER NOT NULL, `numAsientos` INTEGER NOT NULL, `precioPalomitas` REAL NOT NULL, PRIMARY KEY(`numSalas`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '46cb2feabcdae08f9d5126b22c1d3405')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `clientes`");
        db.execSQL("DROP TABLE IF EXISTS `configuracion`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsClientes = new HashMap<String, TableInfo.Column>(3);
        _columnsClientes.put("Id", new TableInfo.Column("Id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("salaElegida", new TableInfo.Column("salaElegida", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("palomitas", new TableInfo.Column("palomitas", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClientes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientes = new TableInfo("clientes", _columnsClientes, _foreignKeysClientes, _indicesClientes);
        final TableInfo _existingClientes = TableInfo.read(db, "clientes");
        if (!_infoClientes.equals(_existingClientes)) {
          return new RoomOpenHelper.ValidationResult(false, "clientes(com.example.examen1moviles.room.ClientesEntity).\n"
                  + " Expected:\n" + _infoClientes + "\n"
                  + " Found:\n" + _existingClientes);
        }
        final HashMap<String, TableInfo.Column> _columnsConfiguracion = new HashMap<String, TableInfo.Column>(3);
        _columnsConfiguracion.put("numSalas", new TableInfo.Column("numSalas", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfiguracion.put("numAsientos", new TableInfo.Column("numAsientos", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfiguracion.put("precioPalomitas", new TableInfo.Column("precioPalomitas", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConfiguracion = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConfiguracion = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConfiguracion = new TableInfo("configuracion", _columnsConfiguracion, _foreignKeysConfiguracion, _indicesConfiguracion);
        final TableInfo _existingConfiguracion = TableInfo.read(db, "configuracion");
        if (!_infoConfiguracion.equals(_existingConfiguracion)) {
          return new RoomOpenHelper.ValidationResult(false, "configuracion(com.example.examen1moviles.room.ConfiguraciónEntity).\n"
                  + " Expected:\n" + _infoConfiguracion + "\n"
                  + " Found:\n" + _existingConfiguracion);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "46cb2feabcdae08f9d5126b22c1d3405", "5fa01f48b4725ddf1dd8a40db848ba94");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "clientes","configuracion");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `clientes`");
      _db.execSQL("DELETE FROM `configuracion`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ExamenDao.class, ExamenDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ExamenDao appDao() {
    if (_examenDao != null) {
      return _examenDao;
    } else {
      synchronized(this) {
        if(_examenDao == null) {
          _examenDao = new ExamenDao_Impl(this);
        }
        return _examenDao;
      }
    }
  }
}
