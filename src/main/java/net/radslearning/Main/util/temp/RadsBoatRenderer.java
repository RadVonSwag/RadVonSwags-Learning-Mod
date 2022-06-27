package net.radslearning.Main.util.temp;
// package net.radslearning.Main.entities.vehicles;

// import java.util.Map;
// import java.util.stream.Stream;

// import javax.annotation.Nonnull;

// import com.google.common.collect.ImmutableMap;
// import com.mojang.datafixers.util.Pair;

// import net.minecraft.client.render.entity.BoatEntityRenderer;
// import net.minecraft.client.render.entity.EntityRendererFactory.Context;
// import net.minecraft.client.render.entity.model.BoatEntityModel;
// import net.minecraft.client.render.entity.model.EntityModelLayers;
// import net.minecraft.entity.vehicle.BoatEntity;
// import net.minecraft.util.Identifier;

// public class RadsBoatRenderer extends BoatEntityRenderer {

//     private final Map<BoatEntity.Type, Pair<Identifier, BoatEntityModel>> texturesAndModels;

//     public RadsBoatRenderer(Context context) {
//         super(context);
//         this.texturesAndModels = Stream.of(BoatEntity.Type.values())
//                 .collect(ImmutableMap.toImmutableMap(type -> type,
//                         boatType -> Pair.of(new Identifier("textures/entity/boat/" + boatType.getName() + ".png"),
//                                 new BoatEntityModel(context.getPart(EntityModelLayers.createBoat(boatType))))));

//     }

//     @Nonnull
//     @Override
//     public Identifier getTexture(BoatEntity boatEntity) {
//         return this.texturesAndModels.get((Object) boatEntity.getBoatType()).getFirst();
//     }

// }
