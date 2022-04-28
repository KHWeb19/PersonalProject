<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4 col-md-6 col-lg-7">
        <section
          @submit.prevent="onSubmit"
          class="product-section product-review"
          id="product-review"
          role="tabpanel"
        >
          <header class="product-section-header">
            <h1 class="title">리뷰</h1>
          </header>
          <form>
            <div
              v-for="commenList in productComments"
              :key="commenList.commentNo"
              class="product-section-content"
            >
              <ol class="review-list">
                <li
                  class="review-item"
                  style="border-bottom: 1px solid #e0e2e7"
                >
                  <article class="review-card">
                    <header class="review-card-header">
                      <h3 class="visually-hidden">
                        {{ commenList.writer }}님이 작성한 리뷰
                      </h3>

                      <div class="info">
                        <a class="username" href="/">
                          <strong>{{ commenList.writer }}</strong>
                        </a>

                        <div class="detail">
                          <div
                            class="star-rating-13"
                            aria-label="5.0점 / 5.0점"
                          >
                            <i class="ic-star is-active"></i>
                            <i class="ic-star is-active"></i>
                            <i class="ic-star is-active"></i>
                            <i class="ic-star"></i>
                            <i class="ic-star"></i>
                          </div>
                          <div class="misc">
                            {{ commenList.regDate }}
                          </div>
                        </div>
                      </div>
                    </header>
                    <div class="review-card-body">
                      <p>
                        {{ commenList.comment }}
                      </p>
                    </div>

                    <footer class="review-card-footer">
                      <button
                        @click="onLike"
                        class="btn-primary btn-32"
                        type="button"
                      >
                        <i class="ic-check" aria-hidden></i>
                        도움됨
                      </button>
                      <p>
                        <strong><span></span>명</strong>에게 도움이 되었습니다.
                      </p>
                    </footer>
                    <button
                      @click="onDelete(commenList.commentNo)"
                      class="delete-button"
                      type="button"
                      aria-label="해당 상품을 삭제하기"
                    >
                      <i class="ic-close" aria-hidden></i>
                    </button>
                  </article>
                </li>
              </ol>
            </div>
            <div class="pagination">
              <ol class="page-list">
                <li class="page-item is-active">
                  <a href="/">1</a>
                </li>
                <li class="page-item">
                  <a href="/">2</a>
                </li>
                <li class="page-item">
                  <a href="/">3</a>
                </li>
                <li class="page-item">
                  <a href="/">4</a>
                </li>
                <li class="page-item">
                  <a href="/">5</a>
                </li>
              </ol>
              <button class="page-control page-next" type="button">
                <i class="ic-chevron"></i>
              </button>
            </div>
          </form>
          <form class="review-form">
            <div class="review-card-content">
              <div class="review-card-content header">리뷰 작성</div>
              <textarea
                v-model="comment"
                style="border-radius: 4px"
                class="form-control"
                minlength="20"
                maxlength="1000"
                cols="120"
                rows="32"
                placeholder="자세하고 솔직한 리뷰는 다른 고객에게 큰 도움이 됩니다.(최소 20자 이상)"
              ></textarea>
            </div>
            <div class="review-card-btn">
              <button class="btn-black btn-46" type="submit">완료</button>
            </div>
          </form>
        </section>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios"
export default {
  name: "ProductComment",
  props: {
    productComments: {
      type: Array,
    },
  },
  data() {
    return {
      comment: "",
      regDate: "",
      writer: "",
      userInfo: this.$store.state.userInfo,
      userId: "",
    }
  },
  created() {
    this.writer = this.$store.state.userInfo.userId
  },
  methods: {
    onDelete(commentNo) {
      console.log(commentNo)

      axios
        .delete(`http://localhost:8888/product/comment/delete/${commentNo}`, {
          commentNo,
        })
        .then(() => {
          alert("삭제 성공!")
          history.go(0)
        })
        .catch(() => {
          alert("삭제 실패")
        })
    },
    onSubmit() {
      const { comment, writer } = this
      this.$emit("submit", { comment, writer })
      console.log(comment, writer)
    },
    onLike() {
      const { productId, userId } = this
      axios
        .post(`http://localhost:8888/product/like/${productId}`, userId)
        .then((res) => {
          if (res.data) {
            alert("좋아요 성공")
            this.$router.go()
          } else {
            alert("이미 좋아요를 누르셨습니다.")
          }
        })
        .catch(() => {
          alert("오류 발생")
        })
    },
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/components/review-card";
</style>
