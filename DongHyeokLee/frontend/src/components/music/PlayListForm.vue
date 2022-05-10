<template>
  <!-- https://github.com/TylerPottsDev/vuejs-music-app/blob/master/src/App.vue 음악 플레이어 퍼옴 -->
      <section class="player">
        <div class="songInfo" align="center"> 
         <strong> 
           <v-icon>
             mdi-music
            </v-icon>
          {{ this.current.title }} - {{ this.current.artist}} 
         </strong>
        </div>
        
        <div class="controls">
          <v-btn class="prev" @click="prev" text>
              <v-icon>
                  mdi-skip-previous
              </v-icon>
          </v-btn>
          <v-btn class="play" v-if="!isPlaying" @click="play" text>
              <v-icon>mdi-play</v-icon>
          </v-btn>
          <v-btn class="pause" v-else @click="pause" text>
              <v-icon>mdi-pause</v-icon>
          </v-btn>
          <v-btn class="next" @click="next" text>
              <v-icon>
                  mdi-skip-next
              </v-icon>
          </v-btn>

        </div>
      </section>
</template>

<script>
export default {
        
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
          },
          {
            title: '사람들이 움직이는게',
            artist: 'AKMU',
            src: require('@/assets/music/사람들이 움직이는게.mp3')
          }
        ],
        player: new Audio(),
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
  color: #FFD54F;
 
}
.next, .prev {
  font-size: 16px;
  font-weight: 700;
  padding: 5px 10px;
  margin: 0px 15px;
  color: #FFD54F;
}
.songInfo{
  font-family: 'Nanum Brush Script', cursive;
  font-size: 20px;
 
}
    
</style>