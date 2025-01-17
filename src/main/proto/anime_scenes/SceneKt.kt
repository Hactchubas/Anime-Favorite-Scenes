// Generated by the protocol buffer compiler. DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: allscenes.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package anime_scenes;

@kotlin.jvm.JvmName("-initializescene")
public inline fun scene(block: anime_scenes.SceneKt.Dsl.() -> kotlin.Unit): anime_scenes.Allscenes.Scene =
  anime_scenes.SceneKt.Dsl._create(anime_scenes.Allscenes.Scene.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `anime_scenes.Scene`
 */
public object SceneKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: anime_scenes.Allscenes.Scene.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: anime_scenes.Allscenes.Scene.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): anime_scenes.Allscenes.Scene = _builder.build()

    /**
     * `double id = 1;`
     */
    public var id: kotlin.Double
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * `double id = 1;`
     */
    public fun clearId() {
      _builder.clearId()
    }

    /**
     * `string name = 2;`
     */
    public var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * `string name = 2;`
     */
    public fun clearName() {
      _builder.clearName()
    }

    /**
     * `string episode = 3;`
     */
    public var episode: kotlin.String
      @JvmName("getEpisode")
      get() = _builder.getEpisode()
      @JvmName("setEpisode")
      set(value) {
        _builder.setEpisode(value)
      }
    /**
     * `string episode = 3;`
     */
    public fun clearEpisode() {
      _builder.clearEpisode()
    }

    /**
     * `double likes = 4;`
     */
    public var likes: kotlin.Double
      @JvmName("getLikes")
      get() = _builder.getLikes()
      @JvmName("setLikes")
      set(value) {
        _builder.setLikes(value)
      }
    /**
     * `double likes = 4;`
     */
    public fun clearLikes() {
      _builder.clearLikes()
    }

    /**
     * `double startTime = 5;`
     */
    public var startTime: kotlin.Double
      @JvmName("getStartTime")
      get() = _builder.getStartTime()
      @JvmName("setStartTime")
      set(value) {
        _builder.setStartTime(value)
      }
    /**
     * `double startTime = 5;`
     */
    public fun clearStartTime() {
      _builder.clearStartTime()
    }

    /**
     * `string sceneImage = 6;`
     */
    public var sceneImage: kotlin.String
      @JvmName("getSceneImage")
      get() = _builder.getSceneImage()
      @JvmName("setSceneImage")
      set(value) {
        _builder.setSceneImage(value)
      }
    /**
     * `string sceneImage = 6;`
     */
    public fun clearSceneImage() {
      _builder.clearSceneImage()
    }

    /**
     * `string description = 7;`
     */
    public var description: kotlin.String
      @JvmName("getDescription")
      get() = _builder.getDescription()
      @JvmName("setDescription")
      set(value) {
        _builder.setDescription(value)
      }
    /**
     * `string description = 7;`
     */
    public fun clearDescription() {
      _builder.clearDescription()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun anime_scenes.Allscenes.Scene.copy(block: `anime_scenes`.SceneKt.Dsl.() -> kotlin.Unit): anime_scenes.Allscenes.Scene =
  `anime_scenes`.SceneKt.Dsl._create(this.toBuilder()).apply { block() }._build()

