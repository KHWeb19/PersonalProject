<template>
  <body>
    <header-layout></header-layout>
    <div class="cart">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <div class="cart-content-wrap col-sm-4">
              <div class="cart-content">
                <div class="cart-content-header">
                  <div class="cart-content-header left">
                    <label for="">
                      <input type="checkbox" />
                    </label>
                    <span>모두 선택</span>
                  </div>
                  <span class="cart-content-header right">
                    <button class="cart-content-hedaer delete">선택삭제</button>
                  </span>
                </div>
                <ul class="cart-content-list">
                  <li class="cart-content-item">
                    <article class="cart-content-product">
                      <ul class="cart-content-option">
                        <li class="cart-content-option-list">
                          <article class="cart-content-article">
                            <div>
                              <div>
                                <input type="checkbox" />
                              </div>
                              <a href="/">
                                <div>
                                  <picture>
                                    <img src="" alt="" />
                                  </picture>
                                </div>
                                <div class="prdouct-small-item content">
                                  <h3 class="product-small-itme title">
                                    [남성전용] 나이키 에어맥스
                                  </h3>
                                  <p>무료배송</p>
                                </div>
                              </a>
                              <button class="product-cart-delete">
                                <i class="ic-close"></i>
                              </button>

                              <div class="order-checkouts">
                                <ul class="checkout-list">
                                  <li class="checkout-item">
                                    <div class="checkout-card">
                                      <header class="checkout-header">
                                        <h4 class="checkout-title">
                                          나이키 덩크
                                        </h4>
                                        <button
                                          class="delete-button"
                                          type="button"
                                          aria-label="해당 상품을 삭제하기"
                                        >
                                          <i class="ic-close" aria-hidden></i>
                                        </button>
                                      </header>

                                      <div class="checkout-footer">
                                        <div class="checkout-select">
                                          <select id="checkout-item-1">
                                            <option value="0">1</option>
                                            <option value="1">2</option>
                                            <option value="2">3</option>
                                            <option value="3">4</option>
                                            <option value="4">5</option>
                                            <option value="5">6</option>
                                            <option value="6">7</option>
                                            <option value="7">8</option>
                                            <option value="8">9</option>
                                            <option value="9">10+</option>
                                          </select>
                                          <span>
                                            <i class="ic-caret" aria-hidden></i>
                                          </span>
                                        </div>

                                        <output
                                          class="checkout-output"
                                          for="checkout-item-1"
                                        >
                                          <div class="price">
                                            <strong class="amount"
                                              >32,900</strong
                                            >
                                            <span class="currency">원</span>
                                          </div>
                                        </output>
                                      </div>
                                    </div>
                                  </li>
                                </ul>
                              </div>

                              <div class="cart-content-footer">
                                <span>
                                  <button class="option">옵션변경</button>
                                  <button class="pay">바로구매</button>
                                </span>
                                <span> <span>71,200</span>원 </span>
                              </div>
                            </div>
                          </article>
                        </li>
                      </ul>
                      <footer class="cart-sidebar-delivery">
                        <p>배송비 무료</p>
                      </footer>
                    </article>
                  </li>
                </ul>
              </div>
            </div>
            <div class="cart-sidebar-wrap col-sm-4">
              <dl class="cart-sidebar">
                <div class="cart-sidebar-price">
                  <dt>총 상품 금액</dt>
                  <dd><span class="number">199,000</span>원</dd>
                </div>
                <div class="cart-sidebar-price">
                  <dt>총 배송비</dt>
                  <dd>+<span class="number">0</span>원</dd>
                </div>
                <div class="cart-sidebar-price">
                  <dt>총 할인금액</dt>
                  <dd>-<span class="number">29,000</span>원</dd>
                </div>
                <div class="cart-sidebar-price total">
                  <dt>결제금액</dt>
                  <dd><span class="number">170,000</span>원</dd>
                </div>
              </dl>
              <div class="cart-sidebar-btn">
                <button class="btn-black btn-46">상품 구매하기</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <footer-layout></footer-layout>
  </body>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
export default {
  name: "CartPage",
  components: { HeaderLayout, FooterLayout },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/cart";
@import "~@/assets/scss/components/checkout-card";
</style>
