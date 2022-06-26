// package net.radslearning.Main.util.temp;

// import net.minecraft.entity.vehicle.BoatEntity;
// import net.minecraft.entity.vehicle.BoatEntity.Type;
// import net.minecraft.block.Block;
// import net.minecraft.block.BlockState;
// import net.minecraft.entity.EntityType;
// import net.minecraft.entity.damage.DamageSource;
// import net.minecraft.entity.data.DataTracker;
// import net.minecraft.entity.data.TrackedData;
// import net.minecraft.entity.data.TrackedDataHandlerRegistry;
// import net.minecraft.item.Item;
// import net.minecraft.item.Items;
// import net.minecraft.nbt.NbtCompound;
// import net.minecraft.network.Packet;
// import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
// import net.minecraft.tag.FluidTags;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.world.GameRules;
// import net.minecraft.world.World;
// import net.radslearning.Main.block.RadsLearningBlocks;
// import net.radslearning.Main.item.RadsLearningItems;


// public class RadsBoatEntity extends BoatEntity {

//     private static final TrackedData<Integer> RADS_BOAT_TYPE = DataTracker.registerData(BoatEntity.class, TrackedDataHandlerRegistry.INTEGER);
// 	private Location location;
//     private double fallVelocity;

//     public RadsBoatEntity(EntityType<? extends BoatEntity> entityType, World world) {
//         super(entityType, world);
//     }

//     public RadsBoatEntity(World world, double x, double y, double z) {
//         this((EntityType<? extends BoatEntity>)EntityType.BOAT, world);
//         this.setPosition(x, y, z);
//         this.prevX = x;
//         this.prevY = y;
//         this.prevZ = z;
//     }

//     protected void initDataTracker() {
//         super.initDataTracker();
//         this.dataTracker.startTracking(RADS_BOAT_TYPE, RadsType.LEMON_WOOD.ordinal());
//     }

//     protected void readCustomDataFromNbt(NbtCompound nbt) {
//         if (nbt.contains("Type", 8)) {
//             this.setBoatType(RadsType.getTypeFromString(nbt.getString("Type")));
//         }

//     }

//     public void setBoatType(RadsType boatType) {
//         this.dataTracker.set(RADS_BOAT_TYPE, boatType.ordinal());
//     }

//     public Item asItem() {
//         switch(this.getRadsBoatType()) {
//             case LEMON_WOOD: {
//                 return RadsLearningItems.LEMON_WOOD_BOAT;
//             }
//             default:
//                 return RadsLearningItems.LEMON_WOOD_BOAT;
//         }
//     }

//     protected void writeCustomDataToNbt(NbtCompound nbt) {
//         nbt.putString("Type", this.getRadsBoatType().getName());
//     }

//     protected void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) {
//         this.fallVelocity = this.getVelocity().y;
//         if (this.hasVehicle()) {
//             return;
//         }
//         if (onGround) {
//             if (this.fallDistance > 3.0f) {
//                 if (this.location != Location.ON_LAND) {
//                     this.onLanding();
//                     return;
//                 }
//                 this.handleFallDamage(this.fallDistance, 1.0f, DamageSource.FALL);
//                 if (!this.world.isClient && !this.isRemoved()) {
//                     this.kill();
//                     if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
//                         int i;
//                         for (i = 0; i < 3; ++i) {
//                             this.dropItem(this.getBoatType().getBaseBlock());
//                         }
//                         for (i = 0; i < 2; ++i) {
//                             this.dropItem(Items.STICK);
//                         }
//                     }
//                 }
//             }
//             this.onLanding();
//         } else if (!this.world.getFluidState(this.getBlockPos().down()).isIn(FluidTags.WATER) && heightDifference < 0.0) {
//             this.fallDistance = (float)((double)this.fallDistance - heightDifference);
//         }
//     }

//     public RadsType getRadsBoatType() {
//         return RadsType.byId(this.dataTracker.get(RADS_BOAT_TYPE));
//     }

//     public static enum RadsType {
//         LEMON_WOOD(RadsLearningBlocks.LEMON_WOOD_PLANKS, "lemon_wood");

//         private final String name;
//         private final Block block;

//         private RadsType(Block block, String name) {
//             this.name = name;
//             this.block = block;
//         }

//         public String getName() {
//             return this.name;
//         }

//         public Block asPlank() {
//             return this.block;
//         }

//         public String toString() {
//             return this.name;
//         }

//         /**
//          * Get a boat type by it's enum ordinal
//          */
//         public static RadsBoatEntity.RadsType byId(int id) {
//             RadsBoatEntity.RadsType[] aboatentity$type = values();
//             if (id < 0 || id >= aboatentity$type.length) {
//                 id = 0;
//             }

//             return aboatentity$type[id];
//         }

//         public static RadsBoatEntity.RadsType getTypeFromString(String nameIn) {
//             RadsBoatEntity.RadsType[] aboatentity$type = values();

//             for(int i = 0; i < aboatentity$type.length; ++i) {
//                 if (aboatentity$type[i].getName().equals(nameIn)) {
//                     return aboatentity$type[i];
//                 }
//             }

//             return aboatentity$type[0];
//         }
//     }

//     @Override
//     public Packet<?> createSpawnPacket() {
//         return new EntitySpawnS2CPacket(this);
//     }
// }
