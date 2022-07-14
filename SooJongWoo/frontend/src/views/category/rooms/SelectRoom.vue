<template>
  <div style="margin-top: -1%; margin-bottom: 0%">
    <section class="cards-wrapper">
      <div class="card-grid-space">
        <router-link to="/roseRoom">
          <a
            class="card"
            style="
              --bg-img: url(https://images.pexels.com/photos/6580228/pexels-photo-6580228.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260);
            "
          >
            <div>
              <h1>#Rose</h1>
              <p>레드톤</p>
              <div class="tags">
                <div class="tag">#2인</div>
                <div class="tag">#연인</div>
                <div class="tag">#Red</div>
              </div>
            </div>
          </a>
        </router-link>
      </div>

      <div class="card-grid-space">
        <router-link to="/sunflowerRoom">
          <a
            class="card"
            style="
              --bg-img: url(https://images.pexels.com/photos/6394651/pexels-photo-6394651.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260);
            "
          >
            <div>
              <h1>#SunFlower</h1>
              <p>옐로우톤</p>
              <div class="tags">
                <div class="tag">#4인</div>
                <div class="tag">#가족</div>
                <div class="tag">#Yellow</div>
              </div>
            </div>
          </a>
        </router-link>
      </div>

      <div class="card-grid-space">
        <router-link to="/violetRoom">
          <a
            class="card"
            style="
              --bg-img: url(https://images.pexels.com/photos/6585612/pexels-photo-6585612.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260);
            "
          >
            <div>
              <h1>#Violet</h1>
              <p>바이올렛톤</p>
              <div class="tags">
                <div class="tag">#2인</div>
                <div class="tag">#커플</div>
                <div class="tag">#Violet</div>
              </div>
            </div>
          </a>
        </router-link>
      </div>

      <div class="card-grid-space">
        <router-link to="/lilyRoom">
          <a
            class="card"
            style="
              --bg-img: url(https://images.pexels.com/photos/6238614/pexels-photo-6238614.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260);
            "
          >
            <div>
              <h1>#Lily</h1>
              <p>화이트톤</p>
              <div class="tags">
                <div class="tag">#2인</div>
                <div class="tag">#커플</div>
                <div class="tag">#White</div>
              </div>
            </div>
          </a>
        </router-link>
      </div>
    </section>
  </div>
</template>

<style lang="scss" scoped>
:root {
  --color: #3c3163;
  --transition-time: 0.5s;
}
* {
  box-sizing: border-box;
}
.cards-wrapper {
  display: grid;
  justify-content: center;
  align-items: center;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-gap: 1.5rem;
  padding: 4rem;
  margin: 0 auto;
  width: max-content;
}
.card {
  font-family: "Heebo";
  --bg-filter-opacity: 0.5;
  background-image: linear-gradient(
      rgba(0, 0, 0, var(--bg-filter-opacity)),
      rgba(0, 0, 0, var(--bg-filter-opacity))
    ),
    var(--bg-img);
  height: 26em;
  width: 15em;
  font-size: 1.5em;
  color: rgb(255, 255, 255);
  border-radius: 1em;
  padding: 1em;
  display: flex;
  align-items: flex-end;
  background-size: cover;
  background-position: center;
  transition: all, var(--transition-time);
  position: relative;
  overflow: hidden;
  text-decoration: none;
}
.card h1 {
  margin: 0;
  font-size: 1.5em;
  line-height: 1.2em;
  font-family: "Italiana";
}
.card p {
  font-size: 0.75em;
  font-family: "Gowun Batang";
  margin-top: 0.5em;
  line-height: 2em;
}
.card .tags {
  display: flex;
}
.card .tags .tag {
  font-size: 0.75em;
  background: rgba(189, 164, 247, 0.5);
  border-radius: 0.3rem;
  padding: 0 0.5em;
  margin-right: 0.5em;
  line-height: 1.5em;
  transition: all, var(--transition-time);
}
.card:hover {
  height: 410px;
  box-shadow: 20px 20px 40px 0px rgba(0, 0, 0, 0.5);
}
.card:hover:before,
.card:hover:after {
  transform: scale(1);
}
.info {
  font-size: 1.2em;
  display: flex;
  padding: 1em 3em;
  height: 3em;
}
.info img {
  height: 3em;
  margin-right: 0.5em;
}
.info h1 {
  font-size: 1em;
  font-weight: normal;
}
/* MEDIA QUERIES */
@media screen and (max-width: 1285px) {
  .cards-wrapper {
    grid-template-columns: 1fr 1fr;
  }
}
@media screen and (max-width: 500px) {
  .cards-wrapper {
    padding: 4rem 2rem;
  }
  .card {
    max-width: calc(100vw - 4rem);
  }
}
@media screen and (max-width: 450px) {
  .info {
    display: block;
    text-align: center;
  }
  .info h1 {
    margin: 0;
  }
}
</style>