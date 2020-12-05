#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
using namespace std;
using namespace __gnu_pbds;

#define ll long long
#define ar array

typedef tree<int, null_type, less<int>, rb_tree_tag,
tree_order_statistics_node_update> indexed_set;

void solve() {
	int n;
	cin >> n;
	int a[n];
	for(int i=0; i<n; ++i)
		cin >> a[i];
	map<int, int> mp1, mp2;
	a[n]=-1;
	int cnt=1;
	for(int i=0; i<n; ++i) {
		if(a[i]==a[i+1])
			cnt++;
		else {
			mp1[a[i]]++;
			mp2[cnt]++;
			cnt=1;
		}
	}
	bool ok=1;
	for(auto x : mp1)
		if(x.second!=1) {
			ok=0;
			break;
		}
	for(auto x : mp2)
		if(x.second!=1) {
			ok=0;
			break;
		}
	cout << (ok?"YES":"NO") << "\n";
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int t;
	cin >> t;
	while(t--)
		solve();
}
