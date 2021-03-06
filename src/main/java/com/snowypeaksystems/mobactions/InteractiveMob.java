package com.snowypeaksystems.mobactions;

import com.snowypeaksystems.mobactions.data.MobData;

/**
 * A mob that can store MobData.
 *
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public interface InteractiveMob {
  String DATA_KEY = "data";
  String REMOVE_DEFAULT_KEY = "remove-default";

  /** Stores data on the LivingEntity. */
  void store();

  /** Removes data from the LivingEntity. */
  void purge();

  /** Returns true if data is stored on this LivingEntity, false otherwise. */
  boolean exists();

  /** Returns the MobData for the mob. */
  MobData getData();

  /** Sets the mob's MobData. */
  void setData(MobData data);
}
