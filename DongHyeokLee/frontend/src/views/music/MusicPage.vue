<template>
<!-- https://github.com/TylerPottsDev/vuejs-music-app/blob/master/src/App.vue 퍼옴 -->
    <div id="app">
    <v-carousel cycle hide-delimiters height="100%">
        <v-carousel-item v-for="(item,i) in items" :key="i" :src="item.src" >
            <v-row class="fill-height" align="center" justify="center" >
    <main>
      <section class="player">
        <div class="controls">
          <button class="prev" @click="prev">
              <v-icon>
                  mdi-skip-previous
              </v-icon>
          </button>
          <button class="play" v-if="!isPlaying" @click="play">
              <v-icon>mdi-play</v-icon>
          </button>
          <button class="pause" v-else @click="pause">
              <v-icon>mdi-pause</v-icon>
          </button>
          <button class="next" @click="next">
              <v-icon>
                  mdi-skip-next
              </v-icon>
          </button>
        </div>
      </section>
      <section class="playlist">
        <h3>The Playlist</h3>
        <button v-for="song in songs" :key="song.src" @click="play(song)" :class="(song.src == current.src) ? 'song playing' : 'song'">
          {{ song.title }} - {{ song.artist }}
        </button>
      </section>
    </main>
      </v-row>
      </v-carousel-item>
    </v-carousel>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      current: {},
      index: 0,
      isPlaying: false,
      songs: [
        {
          title: 'Dinosaur',
          artist: 'AKMU',
          src: require('@/assets/music/Dinosaur.mp3')
        },
        {
          title: 'Re-Bye',
          artist: 'AKMU',
          src: require('@/assets/music/Re-Bye.mp3')
        }
      ],
      player: new Audio(),
       items: [
                    {
                        src: require('@/assets/music/img/akmuPicture1.jpg'),
                        title: 'logo'
                    },
                    {
                        src: require('@/assets/img/homeBackground.png'),
                        title: 'logo'
                    },
                    {
                        src: require('@/assets/img/homeBackground.png'),
                        title: 'logo'
                    },
                    {
                    src: require('@/assets/img/homeBackground.png'),
                        title: 'logo'
                    }
                ],
    }
  },
  methods: {
    play (song) {
      if (typeof song.src != "undefined") {
        this.current = song;
        this.player.src = this.current.src;
      }
      this.player.play();
      this.player.addEventListener('ended', function () {
        this.index++;
        if (this.index > this.songs.length - 1) {
          this.index = 0;
        }
        this.current = this.songs[this.index];
        this.play(this.current);
      }.bind(this));
      this.isPlaying = true;
    },
    pause () {
      this.player.pause();
      this.isPlaying = false;
    },
    next () {
      this.index++;
      if (this.index > this.songs.length - 1) {
        this.index = 0;
      }
      this.current = this.songs[this.index];
      this.play(this.current);
    },
    prev () {
      this.index--;
      if (this.index < 0) {
        this.index = this.songs.length - 1;
      }
      this.current = this.songs[this.index];
      this.play(this.current);
    }
  },
  created () {
    this.current = this.songs[this.index];
    this.player.src = this.current.src;
  }
}
</script>

<style scoped>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
body {
	font-family: sans-serif;
}
header {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 15px;
	background-color: #212121;
	color: #FFF;
}
main {
  width: 100%;
  max-width: 768px;
  margin: 0 auto;
  padding: 25px;
}
.song-title {
  color: #53565A;
  font-size: 32px;
  font-weight: 700;
  text-transform: uppercase;
  text-align: center;
}
.song-title span {
  font-weight: 400;
  font-style: italic;
}
.controls {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 30px 15px;
}
button {
  appearance: none;
  background: none;
  border: none;
  outline: none;
  cursor: pointer;
}
button:hover {
  opacity: 0.8;
}
.play, .pause {
  font-size: 5px;
  font-weight: 700;
  padding: 5px 10px;
  margin: 0px 15px;
  border-radius: 6px;
  color: #FFF;
  background-color: greenyellow;
}
.next, .prev {
  font-size: 16px;
  font-weight: 700;
  padding: 5px 10px;
  margin: 0px 15px;
  border-radius: 6px;
  color: #FFF;
  background-color: greenyellow;
}
.playlist {
  padding: 0px 30px;
}
.playlist h3 {
  color: #212121;
  font-size: 28px;
  font-weight: 400;
  margin-bottom: 30px;
  text-align: center;
}
.playlist .song {
  display: block;
  width: 100%;
  padding: 15px;
  font-size: 20px;
  font-weight: 700;
  cursor: pointer;
}
.playlist .song:hover {
  color: #FF5858;
}
.playlist .song.playing {
  color: #FFF;
  background-image: linear-gradient(to right, #CC2E5D, #FF5858);
}
</style>